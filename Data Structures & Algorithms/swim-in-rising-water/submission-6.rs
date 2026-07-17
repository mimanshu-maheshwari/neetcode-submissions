use std::collections::BinaryHeap;
impl Solution {
    pub fn swim_in_water(grid: Vec<Vec<i32>>) -> i32 {
        let n = grid.len();
        let mut min_heap = BinaryHeap::new();
        let mut dist = vec![vec![3000i32; n]; n];

        dist[0][0] = grid[0][0];

        min_heap.push(Reverse((dist[0][0], 0usize, 0usize)));

        while let Some(Reverse((cost, row, col))) = min_heap.pop() {
            if row + 1 == n && col + 1 == n {
                return cost;
            }

            if cost > dist[row][col] {
                continue;
            }

            for (nr, nc) in Self::neighbors((row, col), n) {
                let new_cost = grid[nr][nc].max(cost);
                if new_cost < dist[nr][nc] {
                    dist[nr][nc] = new_cost;
                    min_heap.push(Reverse((new_cost, nr, nc)));
                }
            }
        }
        dist[n - 1][n - 1]

    }
    
    fn neighbors((row, col): (usize, usize), n: usize) -> impl Iterator<Item=(usize, usize)> {
        let mut result = Vec::with_capacity(4);
        if row > 0 { result.push((row - 1, col)); }
        if col > 0 { result.push((row, col - 1)); }
        if row < n - 1 { result.push((row + 1, col)); }
        if col < n - 1 { result.push((row, col + 1)); }
        result.into_iter()
    }
}
