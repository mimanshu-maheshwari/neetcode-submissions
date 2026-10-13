class Solution {
    private HashSet<Integer> cols, posDiag, negDiag;
    public List<List<String>> solveNQueens(int n) {
        cols       = new HashSet<>();
        posDiag    = new HashSet<>();
        negDiag    = new HashSet<>();

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
            if (this.cols.contains(col) || this.negDiag.contains(row - col) || this.posDiag.contains(row + col)) {
                continue;
            } else {
                // set
                board[row][col] = 'Q';
                this.cols.add(col);
                this.negDiag.add(row - col);
                this.posDiag.add(row + col);

                // backtrack
                backtrack(n, row + 1, board, result);

                // reset
                board[row][col] = '.';
                this.cols.remove(col);
                this.negDiag.remove(row - col);
                this.posDiag.remove(row + col);
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
