class Solution {
    int [] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int c = cost[index];
        return dp[index] = c + Math.min(dfs(cost, index + 1), dfs(cost, index + 2));
    }
}
