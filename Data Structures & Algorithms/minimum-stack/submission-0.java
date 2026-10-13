record Pair(int val, int min){}
class MinStack {

    private Stack<Pair> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (this.stack.isEmpty()) {
            this.stack.push(new Pair(val, val));
        } else {
            this.stack.push(new Pair(val, Math.min(this.stack.peek().min(), val)));
        }
    }
    
    public void pop() {
        if (!this.stack.isEmpty()) {
            this.stack.pop();
        }
    }
    
    public int top() {
        return this.stack.peek().val();
    }
    
    public int getMin() {
        return this.stack.peek().min();
    }
}
