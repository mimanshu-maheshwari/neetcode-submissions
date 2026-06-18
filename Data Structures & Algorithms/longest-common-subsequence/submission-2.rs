impl Solution {
    pub fn longest_common_subsequence(text1: String, text2: String) -> i32 {
        let (t1, t2) = if text1.len() >= text2.len() {
            (text1.as_bytes(), text2.as_bytes())
        } else {
            (text2.as_bytes(), text1.as_bytes())
        };

        let mut dp = vec![0i32; t2.len() + 1];

        for i in (0..t1.len()).rev() {
            let mut prev = 0;
            for j in (0..t2.len()).rev() {
                let temp = dp[j];
                if t1[i] == t2[j] {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = dp[j].max(dp[j + 1]);
                }
                prev = temp;
            }
        }

        dp[0]
    }
}