class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; --i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
