class Solution {
    public int[][] transpose(int[][] matrix) {
        final int m = matrix.length, n = matrix[0].length;
        var output = new int[n][m];
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                output[col][row] = matrix[row][col];
            }
        }
        return output;
    }
}