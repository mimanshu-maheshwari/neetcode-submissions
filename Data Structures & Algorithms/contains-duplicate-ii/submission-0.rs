use std::collections::HashMap;
impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        let k = k as usize;
        let mut map = HashMap::new();
        for (i, val) in nums.iter().enumerate() {
            if map.contains_key(val) {
                if i - map[val]  <= k {
                    return true;
                }
            }
            map.insert(val, i);
        }
        false
    }
}
