class MyHashSet {

private final int SIZE = 1000; // number of buckets
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int idx = hash(key);

        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<>();
        }

        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
        }
    }

    public void remove(int key) {
        int idx = hash(key);

        if (buckets[idx] == null) return;

        buckets[idx].remove((Integer) key); // remove by value, not index
    }

    public boolean contains(int key) {
        int idx = hash(key);

        if (buckets[idx] == null) return false;

        return buckets[idx].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */