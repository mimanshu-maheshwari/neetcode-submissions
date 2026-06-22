class Node {
    int key;
    int value;
    int freq;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.next = null;
        this.prev = null;
    }

    public Node(int key, int value, int freq, Node next, Node prev) {
        this.key = key;
        this.value = value;
        this.freq = freq;
        this.next = next;
        this.prev = prev;
    }
}

class DLList {
    Node left, right;
    int size;
    public DLList(){
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.prev = left;
        this.size = 0;
    }

    public int length() {
        return this.size;
    }
    public void pushRight(Node node) {
        var prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        node.prev = prev;
        this.right.prev = node;
        size++;
    }

    public void pop(Node node) {
        if (size == 0){
            return;
        }
        Node prev = node.prev, next = node.next;
        node.prev = null;
        node.next = null;
        prev.next = next;
        next.prev = prev;
        size--;
    }
    public Node popLeft() {
        if (size == 0) {
            return null;
        }
        Node node = this.left.next;
        pop(node);
        return node;
    }
}

class LFUCache {

    private Map<Integer, Node> keyNodeMap;
    private Map<Integer, DLList> freqDLListMap;
    private int lfuCount, capacity;

    public LFUCache(int capacity) {
        this.keyNodeMap = new HashMap<>();
        this.freqDLListMap = new HashMap<>();
        this.capacity = capacity;
        lfuCount = 0;
    }

    public void counter(Node node) {
        int count = node.freq;
        freqDLListMap.get(count).pop(node);
        if (count == lfuCount && freqDLListMap.get(count).length() == 0) {
            lfuCount++;
        }
        node.freq++;
        freqDLListMap.putIfAbsent(node.freq, new DLList());
        freqDLListMap.get(node.freq).pushRight(node);
    }
    
    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyNodeMap.get(key);
        counter(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyNodeMap.containsKey(key)) {
            var node = keyNodeMap.get(key);
            node.value = value;
            counter(node);
            return;
        }
        if (keyNodeMap.size() == capacity) {
            Node toRemove = freqDLListMap.get(lfuCount).popLeft();
            keyNodeMap.remove(toRemove.key);
        }

        var node = new Node(key, value);
        keyNodeMap.put(key, node);
        freqDLListMap.putIfAbsent(1, new DLList());
        freqDLListMap.get(1).pushRight(node);
        lfuCount = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */