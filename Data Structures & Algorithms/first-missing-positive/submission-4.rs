use std::collections::HashSet;
impl Solution {
    pub fn first_missing_positive(mut nums: Vec<i32>) -> i32 {
        // nums.sort_unstable();
        let mut set = HashSet::new();
        let mut l = 1;
        let mut r = 1.max(nums.iter().map(|&i| {
            set.insert(i);
            i
        }).max().unwrap_or(0) + 1);
        let mut res = r;
        for i in l..=r {
            if (!set.contains(&i)) {
                return i;
            }
        }
        res
    }
}
