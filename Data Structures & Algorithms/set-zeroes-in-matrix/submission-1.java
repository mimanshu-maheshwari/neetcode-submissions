class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        boolean rowZero = false;
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    if (row > 0) {
                        matrix[row][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }
        for (int r = 1; r < ROWS; ++r) {
            for (int c = 1; c < COLS; ++c) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0){
                    matrix[r][c] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int r = 0; r < ROWS; ++r) {
                matrix[r][0] = 0;
            }
        }
        if (rowZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
