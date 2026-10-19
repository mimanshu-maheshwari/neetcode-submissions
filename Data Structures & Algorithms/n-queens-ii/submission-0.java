class Solution {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return backtrack(n, board, 0, 0, 0, 0);
    }

    private int backtrack(int n, int[][] board, int row, int cols, int posDiag, int negDiag) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; ++col) {
            if (!validatePosition(n, row, col, cols, posDiag, negDiag)) {
                continue;
            }
            count += backtrack(
                n, board, row + 1, 
                (cols ^ (1 << col)), 
                (posDiag ^ (1 << (row + col))), 
                (negDiag ^ (1 << (row - col + n)))
            );
        }
        return count;
    }
    private boolean validatePosition(int n,int row, int col, int cols, int posDiag, int negDiag) {
        if (((cols >> col) & 1) == 1) {
            return false;
        }
        if (((posDiag >> (row + col)) & 1) == 1) {
            return false;
        }
        if (((negDiag >> (row - col + n)) & 1) == 1) {
            return false;
        }
        return true;
    }

}