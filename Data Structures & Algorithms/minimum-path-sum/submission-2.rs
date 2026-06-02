impl Solution {

    pub fn min_path_sum(grid: Vec<Vec<i32>>) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        let mut memo = vec![vec![-1; n];m];
        Self::dfs(&grid, 0, 0, &mut memo)
    }

    fn dfs(grid: &[Vec<i32>], row: usize, col: usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        if row >= grid.len() || col >= grid[row].len() {
            return i32::MAX;
        }
        if row + 1 == grid.len() && col + 1 == grid[row].len() {
            return grid[row][col];
        }

        if memo[row][col] != -1 {
            return memo[row][col];
        }
        memo[row][col] = grid[row][col] + Self::dfs(grid, row + 1, col, memo).min(Self::dfs(grid, row, col + 1, memo));
        memo[row][col]
    }
    
}
