class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int zeroCols[] = new int[COLS];
        Arrays.fill(zeroCols, -1);
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (matrix[row][col] == 0){
                    zeroCols[col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = 0; row < ROWS; ++row) {
            if (matrix[row][0] == 0){
                Arrays.fill(matrix[row], 0);
            }
        }
        for (int i = 0; i < COLS; ++i) {
            if (zeroCols[i] == 0){
                for (int row = 0; row < ROWS; ++row) {
                    matrix[row][i] = 0;
                }
            }
        }
    }
}
