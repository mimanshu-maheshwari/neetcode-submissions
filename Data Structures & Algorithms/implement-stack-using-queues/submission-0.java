class MyStack {
    Deque<Integer> queue;
    Deque<Integer> auxQueue;
    public MyStack() {
        queue = new ArrayDeque<>();
        auxQueue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while(!queue.isEmpty()) {
            auxQueue.offer(queue.poll());
        }
        queue.offer(x);
        while(!auxQueue.isEmpty()){
            queue.offer(auxQueue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */