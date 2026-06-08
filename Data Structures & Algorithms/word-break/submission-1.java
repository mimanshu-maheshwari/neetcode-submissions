class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s, wordDict, 0, memo);
    }
    private boolean dfs(String s, List<String> wordDict, int index, int[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != -1) {
            return memo[index] == 1;
        }
        for (String word: wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            if (s.substring(index, index + word.length()).equals(word)) {
                boolean isPossible = dfs(s, wordDict, index + word.length(), memo);
                if (isPossible) {
                    memo[index] = 1;
                    return true;
                }
            } 
        }
        memo[index] = 0;
        return false;
    }
}
