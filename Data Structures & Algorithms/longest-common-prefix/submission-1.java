class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs[0].length() == 0){
            return "";
        }
        outer: for (int j = 0; j < strs[0].length(); j++) {
            char search = strs[0].charAt(j);
            inner: for (int i = 1; i < strs.length; i++){
                if (strs[i].length() <= j || search != strs[i].charAt(j)) {
                    break outer;
                }
            }
            ans.append("" + search);
        }

        return ans.toString();
    }
}