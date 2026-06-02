impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let mut memo = vec![-1; nums.len() + 1];
        Self::dfs(&nums, 0, &mut memo)
    }

    fn dfs(nums: &[i32], index: usize, memo: &mut Vec<i32>) -> i32 {
        if index >= nums.len() {
            return 0;
        }

        if memo[index] != -1 {
            return memo[index];
        }

        let rob_this = nums[index] + Self::dfs(nums, index + 2, memo);
        let skip_this = Self::dfs(nums, index + 1, memo);

        memo[index] = rob_this.max(skip_this);
        memo[index]
    }
}
