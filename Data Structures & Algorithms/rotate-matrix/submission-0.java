class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++ col) {
                if (row == col) {
                    break;
                }
                swap(matrix, row, col, col, row);
            }
        }
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n / 2; ++col) {
                swap(matrix, row, col, row, n - col - 1);
            }
        }
    }
    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
