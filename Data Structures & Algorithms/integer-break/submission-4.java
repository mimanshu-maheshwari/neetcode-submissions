class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int maxProduct = 0;

        for (int i = 1; i < n; i++) {
            maxProduct = Math.max(
                maxProduct,
                Math.max(
                    i * (n - i),       // don't break n-i further
                    i * dfs(n - i, memo) // break n-i further
                )
            );
        }

        return memo[n] = maxProduct;
    }
}