impl Solution {
    pub fn combination_sum2(mut candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        candidates.sort_unstable();

        // Compress into (value, count)
        let mut vals: Vec<(i32, usize)> = Vec::new();
        for x in candidates {
            if let Some(last) = vals.last_mut() {
                if last.0 == x {
                    last.1 += 1;
                } else {
                    vals.push((x, 1));
                }
            } else {
                vals.push((x, 1));
            }
        }

        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut comb: Vec<i32> = Vec::new();
        Self::dfs_counts(&vals, target, 0, &mut comb, &mut result);
        result
    }

    fn dfs_counts(
        vals: &[(i32, usize)],
        target: i32,
        idx: usize,
        comb: &mut Vec<i32>,
        result: &mut Vec<Vec<i32>>,
    ) {
        if target == 0 {
            result.push(comb.clone());
            return;
        }
        if idx == vals.len() {
            return;
        }

        let (v, cnt) = vals[idx];
        let max_take = std::cmp::min(cnt as i32, (target / v) as i32);

        // Take k copies of v, where k = 0..max_take
        for k in 0..=max_take {
            // add k copies
            for _ in 0..k {
                comb.push(v);
            }

            Self::dfs_counts(vals, target - k * v, idx + 1, comb, result);

            // remove k copies
            for _ in 0..k {
                comb.pop();
            }
        }
    }
}
