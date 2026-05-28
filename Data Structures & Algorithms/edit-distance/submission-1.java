class Solution {
    private int[][] dp; 
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int l1 = w1.length, l2 = w2.length;
        dp = new int[l1][l2];
        for (int[] a: dp) {
            Arrays.fill(a, -1);
        }
        return dfs(w1, w2, 0, 0);
    }
    private int dfs(char[] w1, char[] w2, int p1, int p2) {
        if (p1 >= w1.length && p2 >= w2.length) {
            return 0;
        }
        if (p1 >= w1.length || p2 >= w2.length) {
            return Math.max(w2.length - p2, w1.length - p1);
        }
        if (dp[p1][p2] != -1) {
            return dp[p1][p2];
        }
        if (w1[p1] == w2[p2]) {
            return dp[p1][p2] = dfs(w1, w2, p1 + 1, p2 + 1);
        }
        return dp[p1][p2] = 1 + Math.min(
            Math.min(
                dfs(w1, w2, p1 + 1, p2), 
                dfs(w1, w2, p1, p2 + 1)
            ),
            dfs(w1, w2, p1 + 1, p2 + 1)
        );
    }
}
