struct DLNode {
    key: i32,
    val: i32,
    freq: i32,
    prev: usize,
    next: usize,
}

struct DoublyLinkedList {
    left: usize,
    right: usize,
    size: usize,
}

struct LFUCache {
    capacity: usize,
    lfu_count: i32,
    next_id: usize,
    nodes: HashMap<usize, DLNode>,
    node_map: HashMap<i32, usize>,
    list_map: HashMap<i32, DoublyLinkedList>,
}

impl LFUCache {
    fn new(capacity: i32) -> Self {
        LFUCache {
            capacity: capacity as usize,
            lfu_count: 0,
            next_id: 0,
            nodes: HashMap::new(),
            node_map: HashMap::new(),
            list_map: HashMap::new(),
        }
    }

    fn make_list(&mut self) -> DoublyLinkedList {
        let left = self.next_id;
        self.next_id += 1;
        let right = self.next_id;
        self.next_id += 1;

        self.nodes.insert(left, DLNode { key: 0, val: 0, freq: 0, prev: left, next: right });
        self.nodes.insert(right, DLNode { key: 0, val: 0, freq: 0, prev: left, next: right });

        DoublyLinkedList { left, right, size: 0 }
    }

    fn ensure_list(&mut self, freq: i32) {
        if !self.list_map.contains_key(&freq) {
            let list = self.make_list();
            self.list_map.insert(freq, list);
        }
    }

    fn push_right(&mut self, freq: i32, idx: usize) {
        self.ensure_list(freq);
        let right = self.list_map.get(&freq).unwrap().right;
        let prev = self.nodes.get(&right).unwrap().prev;

        self.nodes.get_mut(&prev).unwrap().next = idx;
        {
            let node = self.nodes.get_mut(&idx).unwrap();
            node.prev = prev;
            node.next = right;
        }
        self.nodes.get_mut(&right).unwrap().prev = idx;
        self.list_map.get_mut(&freq).unwrap().size += 1;
    }

    fn pop(&mut self, freq: i32, idx: usize) {
        let (prev, next) = {
            let node = self.nodes.get(&idx).unwrap();
            (node.prev, node.next)
        };

        self.nodes.get_mut(&prev).unwrap().next = next;
        self.nodes.get_mut(&next).unwrap().prev = prev;
        {
            let node = self.nodes.get_mut(&idx).unwrap();
            node.prev = idx;
            node.next = idx;
        }
        self.list_map.get_mut(&freq).unwrap().size -= 1;
    }

    fn pop_left(&mut self, freq: i32) -> usize {
        let left = self.list_map.get(&freq).unwrap().left;
        let idx = self.nodes.get(&left).unwrap().next;
        self.pop(freq, idx);
        idx
    }

    fn counter(&mut self, key: i32) {
        let idx = *self.node_map.get(&key).unwrap();
        let count = self.nodes.get(&idx).unwrap().freq;
        self.pop(count, idx);

        if count == self.lfu_count && self.list_map.get(&count).unwrap().size == 0 {
            self.lfu_count += 1;
        }

        self.nodes.get_mut(&idx).unwrap().freq += 1;
        let next_freq = self.nodes.get(&idx).unwrap().freq;
        self.push_right(next_freq, idx);
    }

    fn get(&mut self, key: i32) -> i32 {
        if !self.node_map.contains_key(&key) {
            return -1;
        }
        self.counter(key);
        let idx = *self.node_map.get(&key).unwrap();
        self.nodes.get(&idx).unwrap().val
    }

    fn put(&mut self, key: i32, value: i32) {
        if self.capacity == 0 {
            return;
        }

        if let Some(&idx) = self.node_map.get(&key) {
            self.nodes.get_mut(&idx).unwrap().val = value;
            self.counter(key);
            return;
        }

        if self.node_map.len() == self.capacity {
            let idx = self.pop_left(self.lfu_count);
            let old_key = self.nodes.get(&idx).unwrap().key;
            self.node_map.remove(&old_key);
            self.nodes.remove(&idx);
        }

        let idx = self.next_id;
        self.next_id += 1;
        self.nodes.insert(idx, DLNode { key, val: value, freq: 1, prev: idx, next: idx });
        self.node_map.insert(key, idx);
        self.push_right(1, idx);
        self.lfu_count = 1;
    }
}