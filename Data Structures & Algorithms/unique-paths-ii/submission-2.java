record Pair(int row, int col){
    public int value(int[][] grid) {
        return grid[this.row][this.col];
    }
    public boolean isValid(int rows, int cols) {
        return !(row < 0 || col < 0 || row >= rows || col >= cols);
    }
}
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (grid[rows - 1][cols -1] == 1 || grid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[rows + 1][cols + 1];
        dp[rows - 1][cols - 1] = 1;
        for (int row = rows - 1; row >= 0; --row) {
            for (int col = cols - 1; col >= 0; --col) {
                if (grid[row][col] == 1) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] += dp[row + 1][col];
                    dp[row][col] += dp[row][col + 1];
                }
            }
        }
        return dp[0][0];
    }
}