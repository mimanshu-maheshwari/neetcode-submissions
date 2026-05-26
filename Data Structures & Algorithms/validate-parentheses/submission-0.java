class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> ref = new HashMap<>();
        ref.put('{','}');
        ref.put('(',')');
        ref.put('[',']');
        for (char c: s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(ref.get(c));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } 
                char i = stack.pop();
                if (i != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
