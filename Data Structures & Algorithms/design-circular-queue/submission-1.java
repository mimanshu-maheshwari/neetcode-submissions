class MyCircularQueue {
    private final int[] arr;
    private final int size;
    private int start = -1, end = -1;
    public MyCircularQueue(int k) {
        this.size = k;
        arr = new int[size];
        Arrays.fill(arr, -1);
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[(++end) % size] = value;
        print();
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        arr[(++start) % size] = -1;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        } 
        return arr[(start + 1) % size];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[end % size];
    }
    
    public boolean isEmpty() {
        return start == end;
    }
    
    public boolean isFull() {
        return end - start == size;
    }
    public void print() {
        System.out.println(Arrays.toString(arr));
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */