impl Solution {
    pub fn num_squares(n: i32) -> i32 {
        let n = n as usize;
        let mut dp = vec![n as i32; n + 1];
        dp[0] = 0;
        for target in 1..=n {
            let mut s = 1;
            while s * s <= target {
                dp[target] = dp[target].min(1 + dp[target - s * s]);
                s += 1;
            }
        }
        dp[n]
    }
}
