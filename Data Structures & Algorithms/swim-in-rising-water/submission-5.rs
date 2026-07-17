use std::collections::BinaryHeap;
impl Solution {
    pub fn swim_in_water(grid: Vec<Vec<i32>>) -> i32 {
        let n = grid.len();
        let mut dist = vec![vec![i32::MAX; n]; n];
        let mut min_heap = BinaryHeap::new();
        dist[0][0] = grid[0][0];

        min_heap.push(Reverse((grid[0][0], 0usize, 0usize)));

        while let Some(Reverse((cost, row, col))) = min_heap.pop() {
            if row == n - 1 && col == n - 1 {
                return cost;
            }

            if cost < dist[row][col] {
                continue;
            }

            for (nr, nc) in Self::neighbors((row, col), (n, n)) {
                let new_cost = cost.max(grid[nr][nc]);
                if new_cost < dist[nr][nc] {
                    dist[nr][nc] = new_cost; 
                    min_heap.push(Reverse((new_cost, nr, nc)));
                }
            }
        }

        dist[n - 1][n - 1]

    }
    fn neighbors((row, col): (usize, usize), (rows, cols): (usize, usize)) 
        -> impl Iterator<Item=(usize, usize)> {
        let mut result = Vec::new();
        if row > 0 { result.push((row-1, col)); }
        if col > 0 { result.push((row, col-1)); }
        if row+1 < rows { result.push((row+1, col)); }
        if col+1 < cols { result.push((row, col+1)); }
        result.into_iter()
    }
}
