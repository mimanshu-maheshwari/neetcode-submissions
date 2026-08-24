impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        Self::dfs(&nums, 0, 0)
    }
    fn dfs(
        nums: &[i32], 
        index: usize, 
        total: i32,
    ) -> i32 {
        if nums.len() == index {
            return total;
        }
        Self::dfs(nums, index + 1, total ^ nums[index]) + 
        Self::dfs(nums, index + 1, total)
    }
}
