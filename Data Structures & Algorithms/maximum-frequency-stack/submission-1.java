public class FreqStack {
    private Map<Integer, Integer> cnt;
    private List<Stack<Integer>> stacks;

    public FreqStack() {
        cnt = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }

    public void push(int val) {
        int valCnt = cnt.getOrDefault(val, 0) + 1;
        cnt.put(val, valCnt);
        if (valCnt == stacks.size()) {
            stacks.add(new Stack<>());
        }
        stacks.get(valCnt).push(val);
    }

    public int pop() {
        Stack<Integer> topStack = stacks.get(stacks.size() - 1);
        int res = topStack.pop();
        cnt.put(res, cnt.get(res) - 1);
        if (topStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return res;
    }
}