impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        use std::collections::HashSet;
        let k: usize = k as usize;
        let mut l: usize = 0;
        let mut window: HashSet<i32> = HashSet::new();
        for r in 0..nums.len() {
            if r - l > k {
                window.remove(&nums[l]);
                l += 1;
            }
            if window.contains(&nums[r]) {
                return true;
            }
            window.insert(nums[r]);
        }
        false
    }
}
