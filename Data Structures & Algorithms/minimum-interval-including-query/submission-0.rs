impl Solution {
    pub fn min_interval(mut intervals: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        let mut queries:Vec<(usize, i32)> = queries.into_iter().enumerate().collect();
        queries.sort_unstable_by_key(|a| a.1);
        intervals.sort_unstable_by(|a, b| {
            let len_a = a[1] - a[0] + 1;
            let len_b = b[1] - b[0] + 1;
            if len_a == len_b {
                a[0].cmp(&b[0])
            } else {
                len_a.cmp(&len_b)
            }
        });
        let mut result = vec![-1; queries.len()];
        for (index, query) in queries {
            for interval in &intervals {
                if interval[0] <= query && query <= interval[1] {
                    result[index] = interval[1] - interval[0] + 1;
                    break;
                }
            }
        }
        result
    }
}
