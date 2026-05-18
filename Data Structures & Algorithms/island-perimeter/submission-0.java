class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] result = new int[1];
        outer: for (int i = 0; i < grid.length; ++i) {
            inner: for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1){ 
                    dfs(grid, i, j, result);
                    break outer;
                }
            }
        }
        return result[0];
    }
    public void dfs(int[][] grid, int row, int col, int[] result) {
        if (grid[row][col] != 1){
            return;
        }
        grid[row][col] = 2;
        int count = 4;
        // up
        if (row > 0 && grid[row - 1][col] != 0) {
            count -= 1;
            dfs(grid, row - 1, col, result);
        }
        // right
        if (col + 1 < grid[0].length && grid[row][col + 1] != 0) {
            count -= 1;
            dfs(grid, row, col + 1, result);
        }
        // down 
        if (row + 1 < grid.length && grid[row + 1][col] != 0) {
            count -= 1;
            dfs(grid, row + 1, col, result);
        }
        // left
        if (col > 0 && grid[row][col - 1] != 0) {
            count -= 1;
            dfs(grid, row, col - 1, result);
        }
        result[0] += count;
    }
}