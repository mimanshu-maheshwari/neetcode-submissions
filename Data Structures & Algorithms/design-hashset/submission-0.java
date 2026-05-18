class MyHashSet {
    private List<Integer>[] arr;
    private final long MAX_SIZE = 99_999;

    public MyHashSet() {
        this.arr = new List[(int) MAX_SIZE];
    }
    
    public void add(int key) {
        if (this.contains(key)){
            return;
        }
        int index = this.hash(key);
        if (arr[index] == null){
            arr[index] = new ArrayList<Integer>();
        }
        arr[index].add(key);
    }
    
    public void remove(int key) {
        if (this.contains(key)){
            int index = this.hash(key);
            if (arr[index] != null){
                int i = arr[index].indexOf(key);
                if (i != -1){
                    arr[index].remove(i);
                }
            }
        } 
    }
    
    public boolean contains(int key) {
        int index = this.hash(key);
        if (arr[index] != null){
            int i = arr[index].indexOf(key);
            if (i != -1){
                return true;
            }
        }
        return false;
    }
    private int hash(long key) {
        return (int) ( ((key + 7l) * 37l) % MAX_SIZE);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */