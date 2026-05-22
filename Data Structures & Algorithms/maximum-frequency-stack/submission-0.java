class FreqStack {
    PriorityQueue<int[]> maxHeap;
    Map<Integer, Integer> freq;
    int index;
    public FreqStack() {
        freq = new HashMap<>();
        maxHeap = new PriorityQueue<>((a,b) -> 
            a[0] != b[0] 
            ? Integer.compare(b[0], a[0]) 
            : Integer.compare(b[1], a[1])
        );
        index = 0;
    }
    
    public void push(int val) {
        freq.merge(val, 1, Integer::sum);
        maxHeap.offer(new int[]{freq.get(val), index++, val});
    }
    
    public int pop() {
        int[] top = maxHeap.poll();
        int val = top[2];
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */