use std::collections::HashSet;
impl Solution {
    pub fn first_missing_positive(mut nums: Vec<i32>) -> i32 {
        // nums.sort_unstable();
        let mut set = HashSet::new();
        for &i in nums.iter() {
            set.insert(i);
        }
        let mut l = 1;
        let mut r = nums.len() as i32 + 1;
        let mut res = r;
        for i in l..=r {
            if !set.contains(&i) {
                return i;
            }
        }
        res
    }
}
