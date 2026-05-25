class DSU{
    private int[] parent, size;
    public DSU(int k) {
        parent = new int[k];
        size = new int[k];
        for (int i = 0; i < k; ++i){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (size[pu] < size[pv]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        size[pu] += size[pv];
        parent[pv] = pu;
        return true;
    }
}

class Solution {
    private final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        DSU dsu = new DSU(ROWS * COLS + 1);
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col){
                if (grid[row][col] == '1') {
                    ++count;
                    for (int[] dir: DIR) {
                        int nr = row + dir[0];
                        int nc = col + dir[1];
                        if (nr >= ROWS || nc >= COLS || nr < 0 || nc < 0 || grid[nr][nc] != '1') {
                            continue;
                        }
                        if (dsu.union(row * COLS + col, nr * COLS+ nc)) {
                            --count;
                        }
                    }
                }
            }
        }
        return count;
    }
}
