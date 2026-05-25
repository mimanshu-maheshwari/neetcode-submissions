class Solution {
    private final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (grid[row][col] == '1') {
                    count++;
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{row, col});
                    grid[row][col] = '#';
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        int r = pos[0];
                        int c = pos[1];
                        for (int[] dir: DIR) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            if (nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc] != '1') {
                                continue;
                            }
                            queue.offer(new int[]{nr, nc});
                            grid[nr][nc] = '#';
                        }
                    }
                }
            }
        }
        return count;
    }
}
