impl Solution {
    pub fn find_target_sum_ways(nums: Vec<i32>, target: i32) -> i32 {
        fn dfs(nums: &[i32], target: i32, index: usize) -> i32 {
            if index == nums.len() {
                if 0 == target {
                    return 1;
                }
                return 0;
            }
            dfs(nums, target - nums[index], index + 1) + dfs(nums, target + nums[index], index + 1)
        }
        dfs(&nums, target, 0)
    }
}
