class Solution {

    private final int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (row == 0 || col == 0 || row == board.length - 1 
                || col == board[0].length - 1) {
                    if (board[row][col] == 'O') {
                        dfs(board, row, col);
                    }
                }
            }
        }
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = '#';
            for (int[] d: D) {
                int dx = d[0], dy = d[1];
                dfs(board, row + dx, col + dy);
            }
        }
    }
}
