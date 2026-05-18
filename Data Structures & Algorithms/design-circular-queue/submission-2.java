class MyCircularQueue {
    private final int[] arr;
    private int size, capacity;
    private int start = -1, end = -1;
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        arr = new int[capacity];
        Arrays.fill(arr, -1);
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[(++end) % capacity] = value;
        ++size;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        arr[(++start) % capacity] = -1;
        --size;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        } 
        return arr[(start + 1) % capacity];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[end % capacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
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