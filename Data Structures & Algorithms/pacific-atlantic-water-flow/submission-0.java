class Solution {
    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length; 
        cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols],
                   atlantic = new boolean[rows][cols];

        for (int c = 0 ; c < cols; ++c){
            dfs(heights, 0, c, pacific, heights[0][c]);
            dfs(heights, rows - 1, c, atlantic, heights[rows - 1][c]);
        }

        for (int r = 0 ; r < rows; ++r){
            dfs(heights, r, 0, pacific, heights[r][0]);
            dfs(heights, r, cols - 1, atlantic, heights[r][cols - 1]);
        }

        var result = new ArrayList<List<Integer>>();
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int previousHeight) {
        if (row < 0 || col < 0 
            || row >= rows || col >= cols 
            || visited[row][col] || heights[row][col] < previousHeight
        ) {
            return;
        }
        visited[row][col] = true;
        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
    }
}
