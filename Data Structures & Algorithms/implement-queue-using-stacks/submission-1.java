class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> auxStack;
    public MyQueue() {
        stack = new Stack<>();
        auxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if (auxStack.isEmpty()) {
            while(!stack.isEmpty()) {
                auxStack.push(stack.pop());
            }
        }
        return auxStack.pop();
    }
    
    public int peek() {
        if (auxStack.isEmpty()) {
            while(!stack.isEmpty()) {
                auxStack.push(stack.pop());
            }
        }
        return auxStack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty() && auxStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */