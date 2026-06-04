// Kahn algorithm (Topological Sort)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        final int ROWS = matrix.length, COLS = matrix[0].length;

        int[][] indegree = new int[ROWS][COLS];

        // generate indegree
        for(int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) { 
                for(int[] dir: dirs) {
                    int dr = dir[0], dc = dir[1];
                    int nr = row + dr, nc = col + dc;
                    if (nr >= ROWS || nc >= COLS || nr < 0 || nc < 0 || matrix[nr][nc] >= matrix[row][col]) {
                        continue;
                    }
                    indegree[row][col]++;
                }
            }
        }

        var queue = new ArrayDeque<int[]>();
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (indegree[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        // bfs
        int lis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                var point = queue.poll();
                int row = point[0], col = point[1];
                for(int[] dir: dirs) {
                    int dr = dir[0], dc = dir[1];
                    int nr = row + dr, nc = col + dc;
                    if (nr >= ROWS || nc >= COLS || nr < 0 || nc < 0 || matrix[nr][nc] <= matrix[row][col]) {
                        continue;
                    }
                    if (--indegree[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            lis++;
        }

        return lis;
    }
}
