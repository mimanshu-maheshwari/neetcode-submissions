struct DSU {
    parent: Vec<usize>,
    size: Vec<usize>,
}

impl DSU {
    fn new(n: usize) -> Self {
        Self {
            parent: (0..n).collect(),
            size: vec![1; n],
        }
    }

    fn find(&mut self, x: usize) -> usize {
        if self.parent[x] != x {
            self.parent[x] = self.find(self.parent[x]);
        }
        self.parent[x]
    }

    fn union(&mut self, u: usize, v: usize) -> bool {
        let (mut pu, mut pv) = (self.find(u), self.find(v));
        if pu == pv {
            return false;
        }
        if self.size[pu] < self.size[pv] {
            std::mem::swap(&mut pu, &mut pv);
        }
        self.size[pu] += self.size[pv];
        self.parent[pv] = pu;
        true
    }

    fn connected(&mut self, u: usize, v: usize) -> bool {
        self.find(u) == self.find(v)
    }
}

impl Solution {
    pub fn swim_in_water(grid: Vec<Vec<i32>>) -> i32 {
        let n = grid.len();
        let mut dsu = DSU::new(n * n);
        let mut positions: Vec<(i32, usize, usize)> = Vec::new();
        for r in 0..n {
            for c in 0..n {
                positions.push((grid[r][c], r, c));
            }
        }
        positions.sort();
        let directions: [(i32, i32); 4] = [(0, 1), (1, 0), (0, -1), (-1, 0)];

        for &(t, r, c) in &positions {
            for &(dr, dc) in &directions {
                let nr = r as i32 + dr;
                let nc = c as i32 + dc;
                if nr >= 0 && nc >= 0 && (nr as usize) < n && (nc as usize) < n {
                    let (nr, nc) = (nr as usize, nc as usize);
                    if grid[nr][nc] <= t {
                        dsu.union(r * n + c, nr * n + nc);
                    }
                }
            }
            if dsu.connected(0, n * n - 1) {
                return t;
            }
        }
        n as i32 * n as i32
    }
}