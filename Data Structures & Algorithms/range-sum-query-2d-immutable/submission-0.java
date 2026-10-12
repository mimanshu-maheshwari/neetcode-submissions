class NumMatrix {

    final int ROWS, COLS;
    final int[][] prefixMatrix;
    public NumMatrix(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        prefixMatrix = new int[ROWS + 1][COLS + 1];
        for (int row = 0; row < ROWS; ++row) {
            int prefix = 0;
            for (int col = 0; col < COLS; ++col) {
                prefix += matrix[row][col];
                int above = prefixMatrix[row][col + 1];
                prefixMatrix[row + 1][col + 1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++;col2++;
        int bottomRight = prefixMatrix[row2][col2];
        int above = prefixMatrix[row1 - 1][col2];
        int left = prefixMatrix[row2][col1 - 1];
        int topLeft = prefixMatrix[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */