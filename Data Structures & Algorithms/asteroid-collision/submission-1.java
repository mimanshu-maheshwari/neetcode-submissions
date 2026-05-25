class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; ++i){
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            } else {
                if (stack.peek() < 0 || (stack.peek() > 0 && asteroids[i] > 0)) {
                    stack.push(asteroids[i]);
                } else {
                    boolean isDestroid = false;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                            stack.pop();
                            isDestroid = true;
                            break;
                        } else if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                            isDestroid = true;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                    if (!isDestroid) {
                        stack.push(asteroids[i]);
                    }
                }
            }
        }

        int result[] = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        return result;
    }
    private boolean sameDirection(int a, int b) {
        return ((a >0 && b > 0) || (a < 0 && b < 0));
    }
}