class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (grid[rows - 1][cols - 1] == 1 || grid[0][0] == 1) {
            return 0;
        }
        grid[rows - 1][cols - 1] = 1;
        for (int r = rows - 1; r >= 0; --r) {
            for (int c = cols - 1; c >= 0; --c) {
                if (r == rows - 1 && c == cols - 1) {
                    continue;
                }
                if (grid[r][c] == 1) {
                    grid[r][c] = 0;
                } else {
                    int down = (r + 1 < rows) ? grid[r + 1][c] : 0;
                    int right = (c + 1 < cols) ? grid[r][c + 1] : 0;
                    grid[r][c] = down + right;
                }
            }
        }
        return grid[0][0];
    }
}