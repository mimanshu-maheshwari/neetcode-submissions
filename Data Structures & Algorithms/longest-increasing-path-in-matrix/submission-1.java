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
                len = Math.max(len, dfs(matrix, new HashSet<>(), row, col));
            }
        }
        return len;
    }
    private int dfs(int[][] matrix, Set<int[]> visited, int row, int col) {
        // if (row >= ROWS || row < 0 || col < 0 || col >= COLS) {
        //     return 0;
        // }
        if (visited.contains(new int[]{row, col})) {
            return 0;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        visited.add(new int[]{row, col});
        int len = 0;
        for (int[] dir: DIR ){
            int dr = dir[0], dc = dir[1];
            int newRow = row + dr, newCol = col + dc;
            if (newRow >= ROWS || newRow < 0 || newCol < 0 || newCol >= COLS || matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            }
            len = Math.max(len, dfs(matrix, visited, newRow, newCol));
        }
        return memo[row][col] = 1 + len;
    }
}
