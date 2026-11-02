class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());
        return dfs(s, 0, dict, maxLen, new HashMap<>());
    }
    
    private List<String> dfs(String s, int start, Set<String> dict,
                         int maxLen, Map<Integer, List<String>> memo) {
        if (start == s.length()) return List.of("");          // one way: empty remainder
        if (memo.containsKey(start)) return memo.get(start);
    
        List<String> res = new ArrayList<>();
        int limit = Math.min(s.length(), start + maxLen);
        for (int end = start + 1; end <= limit; end++) {
            String word = s.substring(start, end);
            if (!dict.contains(word)) continue;
            for (String rest : dfs(s, end, dict, maxLen, memo)) {
                res.add(rest.isEmpty() ? word : word + " " + rest);
            }
        }
        memo.put(start, res);
        return res;
    }
}