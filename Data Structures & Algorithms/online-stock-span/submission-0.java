class StockSpanner {
    record StockSpan(int price, int span) {}
    private Deque<StockSpan> stack;
    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!this.stack.isEmpty() && this.stack.peek().price() <= price) {
            span += this.stack.pop().span();
        }
        this.stack.push(new StockSpan(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */