record Node(int key, int value){}
class MyHashMap {
    private LinkedList<Node>[] buckets;
    private static final int MAX_SIZE = 99_999;

    public MyHashMap() {
        buckets = new LinkedList[MAX_SIZE];
    }
    
    public void put(int key, int value) {
        int index = this.getIndex(key);
        if (buckets[index] == null){
            buckets[index] = new LinkedList<Node>();
        }
        if (this.containsKey(key)) {
            Node node = null;
            for (Node n: buckets[index]) {
                if (n.key() == key) {
                    node = n;
                    break;
                }
            }
            buckets[index].remove(node);
            buckets[index].offer(new Node(key, value));
        } else {
            buckets[index].offer(new Node(key, value));
        }
    }

    public boolean containsKey(int key){
        int index = this.getIndex(key);
        if (buckets[index] != null){
            for (Node node: buckets[index]){
                if (node.key() == key) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int get(int key) {
        if (!this.containsKey(key)){
            return -1;
        }
        int index = this.getIndex(key);
        if (buckets[index] != null){
            for (Node node: buckets[index]){
                if (node.key() == key) {
                    return node.value();
                }
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        if (!this.containsKey(key)){
            return;
        }
        int index = this.getIndex(key);
        if (buckets[index] == null){
            return;
        }
        Node node = null;
        for (Node n: buckets[index]) {
            if (n.key() == key) {
                node = n;
                break;
            }
        }
        buckets[index].remove(node);
    }

    private int getIndex(int key) {
        return ((key + 7) * 37) % MAX_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */