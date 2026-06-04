class Solution {
    int ROWS, COLS;
    int[][] memo;
    private final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        int len = 1;
        memo = new int[ROWS + 1][COLS + 1];
        for (int[] m: memo) {
            Arrays.fill(m, -1);
        }
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                len = Math.max(len, dfs(matrix, row, col));
            }
        }
        return len;
    }
    private int dfs(int[][] matrix, int row, int col) {

        
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        int len = 0;
        for (int[] dir: DIR ){
            int dr = dir[0], dc = dir[1];
            int newRow = row + dr, newCol = col + dc;
            if (newRow >= ROWS || newRow < 0 || newCol < 0 || newCol >= COLS || matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            }
            len = Math.max(len, dfs(matrix, newRow, newCol));
        }
        return memo[row][col] = 1 + len;
    }
}
