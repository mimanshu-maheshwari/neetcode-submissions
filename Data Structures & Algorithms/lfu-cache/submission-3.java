class Node {
    int key, val, freq;
    Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        this.prev = null;
        this.next = null;
    }
    public Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node left, right;
    int size;

    public DoublyLinkedList() {
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
        size = 0;
    }

    public void pop(Node node) {
        if (size == 0){
            return;
        }
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    public Node popLeft() {
        if (size == 0) {
            return null;
        }
        var node = left.next;
        pop(node);
        return node;
    }

    public void pushRight(Node node) {
        var prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
        size++;
    }

    public int length() {
        return size;
    }
}

class LFUCache {

    // node map (key -> node)
    private Map<Integer, Node> nodes;
    // freq map (freq -> doubly linked list) 
    // linked list (oldest -> recent)
    private Map<Integer, DoublyLinkedList> freqs;
    // lfuCount, capacity
    int lfuCount, capacity;


    public LFUCache(int capacity) {
        this.nodes = new HashMap<>();
        this.freqs = new HashMap<>();
        this.lfuCount = 0;
        this.capacity = capacity;
    }

    private void counter(Node node) {
        freqs.get(node.freq).pop(node);
        if (lfuCount == node.freq 
            && freqs.containsKey(lfuCount)
            && freqs.get(lfuCount).length() == 0) {
                lfuCount++;
            }
        node.freq++;
        freqs.computeIfAbsent(
                node.freq, 
                k -> new DoublyLinkedList())
            .pushRight(node);
    }
    
    public int get(int key) {
        if (!nodes.containsKey(key)) {
            return -1;
        }
        var node = nodes.get(key);
        counter(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (nodes.containsKey(key)) {
            var node = nodes.get(key);
            node.val = value;
            counter(node);
            return;
        }
        if (nodes.size() == capacity) {
            var toRemove = freqs.get(lfuCount).popLeft();
            nodes.remove(toRemove.key);
        }
        var node = new Node(key, value);
        nodes.put(key, node);
        lfuCount = 1;
        freqs.computeIfAbsent(
                lfuCount,
                k -> new DoublyLinkedList())
            .pushRight(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */