class Solution {
    public int integerBreak(int n) {
        return dfs(n, n - 1);
    }
    private int dfs(int n, int i) {
        if (Math.min(n, i) == 0) {
            return 1;
        }
        if (i > n){
            return dfs(n, n);
        }
        return Math.max(i * dfs(n - i, i), dfs(n, i - 1));
    }
}