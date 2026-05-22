class KthLargest {
    PriorityQueue<Integer> list = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for (int n: nums) {
            list.offer(n);
        }
        this.k = k;
        while (list.size() > k) {
            list.poll();
        }
    }
    
    public int add(int val) {
        list.offer(val);
        while (list.size() > k) {
            list.poll();
        }
        return list.peek();
    }
}
