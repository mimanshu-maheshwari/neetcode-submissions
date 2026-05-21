class DSU {
    private int[] parent; 
    private int[] size;
    public DSU(int k) {
        parent = new int[k + 1];
        size = new int[k + 1];
        for (int i =  0; i <= k; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        } 
        return parent[x];
    }
    public boolean union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);
        if (parentU == parentV) {
            return false;
        }
        if (size[parentU] < size[parentV]) {
            int temp = parentU;
            parentU = parentV;
            parentV = temp;
        }
        size[parentU] += size[parentV];
        parent[parentV] = parentU;
        return true;
    }
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
class Solution {
    private final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        final int ROWS = board.length, COLS = board[0].length;
        DSU dsu = new DSU(ROWS * COLS + 1);
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (board[row][col] != 'O') {
                    continue;
                }
                if (row == 0 || col == 0 || row + 1 == ROWS || col + 1 == COLS) {
                    dsu.union(ROWS * COLS, row * COLS + col);
                }else {
                    for (int [] dir: DIRS) {
                        int dr = dir[0], dc = dir[1];
                        int newRow = row + dr, newCol = col + dc;
                        if (board[newRow][newCol] == 'O') {
                            dsu.union(row * COLS + col, newRow * COLS + newCol);
                        }
                    }
                }
            }
        }

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (!dsu.connected(ROWS * COLS, row * COLS + col)) {
                    board[row][col] = 'X';
                }
            }
        }
    }
}
