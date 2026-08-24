impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        let mut res = 0;
        let mut subset = Vec::new();
        Self::backtrack(&nums, 0, &mut subset, &mut res);
        res
    }
    fn backtrack(
        nums: &[i32],
        index: usize,
        subset: &mut Vec<i32>, 
        res: &mut i32,
    ) { 
        let mut xor = 0;
        for &num in subset.iter() {
            xor ^= num;
        }
        *res += xor;
        for i in index..nums.len() {
            subset.push(nums[i]);
            Self::backtrack(nums, i + 1, subset, res);
            subset.pop();
        }
    }
}
