impl Solution {
    pub fn erase_overlap_intervals(mut intervals: Vec<Vec<i32>>) -> i32 {
        intervals.sort_unstable_by_key(|v| v[1]);
        let mut prevEnd = intervals[0][1];
        let mut count = 0;
        for interval in intervals.iter().skip(1) {
            if prevEnd > interval[0] {
                count += 1;
            } else {
                prevEnd = interval[1];
            }
        }
        count
    }
}
