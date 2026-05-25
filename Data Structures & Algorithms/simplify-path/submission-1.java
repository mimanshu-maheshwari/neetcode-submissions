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
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (String s: stack ) {
            result.append("/").append(s);
        }
        return result.toString();
    }
}