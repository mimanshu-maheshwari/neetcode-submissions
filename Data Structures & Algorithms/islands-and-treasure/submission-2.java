record Point(int row, int col){
    boolean isValid(int ROWS, int COLS) {
        return !(row < 0 || col < 0 || row >= ROWS || col >= COLS);
    }
    boolean isVisited(Set<Point> visited) {
        return visited.contains(this);
    }
    int value(int[][] grid){
        return grid[row][col];
    }
    Point add(int drow, int dcol) {
        return new Point(row + drow, col + dcol);
    }
}
class Solution {
    private final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Deque<Point> queue = new ArrayDeque<>();
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (grid[row][col] == 0) {
                    Point p = new Point(row, col);
                    queue.offer(p);
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0){
                Point curr = queue.poll();
                for (int [] dir: DIR) {
                    Point newPoint = curr.add(dir[0], dir[1]);
                    if (newPoint.isValid(ROWS, COLS)  && newPoint.value(grid) == Integer.MAX_VALUE){
                        grid[newPoint.row()][newPoint.col()] = curr.value(grid) + 1;
                        queue.offer(newPoint);
                    }
                }
            }
        }
    }
}
