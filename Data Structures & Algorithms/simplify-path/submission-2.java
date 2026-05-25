class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String p: paths) {
            p = p.trim();
            if (p.isEmpty()) { 
                continue;
            }
            if (".".equals(p)){
                continue;
            } else if("..".equals(p)) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(p);
            }
        }
        return "/" + String.join("/", stack);
    }
}