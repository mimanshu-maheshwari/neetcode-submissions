class Solution {
    private int cols, posDiag, negDiag;
    public List<List<String>> solveNQueens(int n) {
        cols       = 0;
        posDiag    = 0;
        negDiag    = 0;

        var board  = new char[n][n];
        var result = new ArrayList<List<String>>();

        for (char[] row: board) {
            Arrays.fill(row, '.');
        }

        backtrack(n, 0, board, result);

        return result;
    }

    private void backtrack(
        int n, int row, char[][] board, List<List<String>> result 
    ) {
        if (row == n) {
            result.add(generateResult(board));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if ((this.cols & (1 << col)) > 0 || (this.negDiag & (1 << (row - col + n))) > 0 || (this.posDiag & (1 << (row + col))) > 0) {
                continue;
            } else {
                // set
                this.cols      ^= (1 << col);
                this.negDiag   ^= (1 << (row - col + n));
                this.posDiag   ^= (1 << (row + col));
                board[row][col] = 'Q';

                // backtrack
                backtrack(n, row + 1, board, result);

                // reset
                this.cols      ^= (1 << col);
                this.negDiag   ^= (1 << (row - col + n));
                this.posDiag   ^= (1 << (row + col));
                board[row][col] = '.';
            }
        }
    }


    private List<String> generateResult(char[][] board) {
        var result = new ArrayList<String>();
        for (char[] row: board) {
            result.add(new String(row));
        }
        return result;
    }
}
