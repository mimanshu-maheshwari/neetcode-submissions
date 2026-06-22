impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut dp = vec![n as i32; n];
        dp[0] = 0;
        for i in 0..n {
            let start = i + 1;
            let end = (i + nums[i] as usize).min(n - 1);
            for j in start..=end {
                dp[j] = (1 + dp[i]).min(dp[j]);
            }
        }
        dp[n - 1]
    }
}
//   [2,4,1,1,1,1]
// [0,6,6,6,6,6,6]
// start = 1
// end = 1 + 2