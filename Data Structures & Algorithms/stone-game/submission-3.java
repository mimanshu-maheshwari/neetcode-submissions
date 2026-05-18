public class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        int total = 0; 
        for (int p: piles) {
            total += p;
        }

        int aliceScore = dfs(0, n - 1, piles, dp);
        return aliceScore > total - aliceScore;
    }
    int dfs (int l, int r, int[] piles, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        boolean even = ((r - l) & 1) == 0;
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;
        return dp[l][r] = Math.max(
            dfs(l + 1, r, piles, dp) + left, 
            dfs(l, r - 1, piles, dp) + right
        );
    }
}