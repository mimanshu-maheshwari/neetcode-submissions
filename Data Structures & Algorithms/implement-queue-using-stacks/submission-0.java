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
        while(!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
        int retValue = auxStack.pop();
        while(!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return retValue;
    }
    
    public int peek() {
                while(!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
        int retValue = auxStack.peek();
        while(!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return retValue;
        
    }
    
    public boolean empty() {
        return stack.isEmpty();
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