class Solution {
    public List<List<String>> solveNQueens(int n) {
        var result = new ArrayList<List<String>>();
        var board = new char[n][n];
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
            if (validPlacement(board, n, row, col)) {
                board[row][col] = 'Q';
                backtrack(n, row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean validPlacement(char[][] board, int n, int row, int col) {
        // check column
        // check row
        for (int i = 0; i < n; ++i) {
            if (board[i][col] == 'Q' || board[row][i] == 'Q') {
                return false;
            }
        }
        
        // check top left diag
        int r = row - 1, c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == 'Q') {
                return false;
            }
        }
        // check top right diag
        r = row - 1; c = col + 1;
        while (r >= 0 && c < n) {
            if (board[r--][c++] == 'Q') {
                return false;
            }
        }
        // check bottom left diag
        r = row + 1; c = col - 1;
        while (r < n && c >= 0) {
            if (board[r++][c--] == 'Q') {
                return false;
            }
        }
        // check bottom right diag
        r = row + 1; c = col + 1;
        while (r < n && c < n) {
            if (board[r++][c++] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> generateResult(char[][] board) {
        var result = new ArrayList<String>();
        for (char[] row: board) {
            result.add(new String(row));
        }
        return result;
    }
}
