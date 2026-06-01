impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        let mut memo = vec![vec![i32::MAX; k as usize + 1]; nums.len()];
        Self::dfs(&nums, 0, k as usize, &mut memo)
    }
    fn dfs(nums: &[i32], index: usize, k : usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        let n = nums.len();
        if k == 1 {
            return nums[index..].iter().sum();
        }
        if memo[index][k] != i32::MAX {
            return memo[index][k];
        }
        let mut curr_sum = 0;
        let mut ans = i32::MAX;
        for j in index..=(n - k) {
            curr_sum += nums[j];
            let right = Self::dfs(nums, j + 1, k - 1, memo);
            ans = ans.min(curr_sum.max(right));
        }
        memo[index][k] = ans;
        ans
    }
}
