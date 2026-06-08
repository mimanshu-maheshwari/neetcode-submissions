class Solution {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int[] m: memo){
            Arrays.fill(m, -1);
        }
        if (t.length() > s.length()){
            return 0;
        }
        return dfs(s, t, 0, 0, memo);
    }
    private int dfs(String s, String t, int i, int j, int[][] memo) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int res = dfs(s, t, i + 1, j, memo);
        if (s.charAt(i) == t.charAt(j)){
            res += dfs(s, t, i + 1, j + 1, memo);
        }
        return memo[i][j] = res;
    }
}
