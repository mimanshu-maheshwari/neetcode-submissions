class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        var dict = new HashSet<String>();
        // memo based on index and result;
        var memo = new HashMap<Integer, Integer>();
        memo.put(s.length(), 0);

        for (String w: dictionary) {
            dict.add(w);
        }

        return dfs(s, dict, 0, memo);
        
    }

    private int dfs(String s, HashSet<String> dict, int index, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // if we skip the char
        int result = 1 + dfs(s, dict, index + 1, memo);

        for (int i = index; i < s.length(); ++i) {
            if (dict.contains(s.substring(index, i + 1))) {
                result = Math.min(result, dfs(s, dict, i + 1, memo));
            }
        }
        
        memo.put(index, result);
        return result;
    }
}