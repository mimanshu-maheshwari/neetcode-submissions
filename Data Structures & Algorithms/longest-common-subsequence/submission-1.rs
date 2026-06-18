impl Solution {
    pub fn longest_common_subsequence(text1: String, text2: String) -> i32 {
        let (l1, l2) = (text1.len(), text2.len());
        let text1: Vec<char> = text1.chars().collect();
        let text2: Vec<char> = text2.chars().collect();
        let mut dp: Vec<Vec<i32>> = vec![vec![0; l2 + 1]; l1 + 1];
        for i in 1..=l1 {
            for j in 1..=l2 {
                dp[i][j] = dp[i - 1][j].max(dp[i][j - 1]);
                if text1[i - 1] == text2[j - 1] {
                    dp[i][j] = dp[i][j].max(dp[i - 1][j - 1] + 1);
                }

            }
        }
        dp[l1][l2] 
    }
}

// _ | _ | c | r | a | b | t |
// _ | 0 | 0 | 0 | 0 | 0 | 0 |
// c | 0 | 1 | 1 | 1 | 1 | 1 |
// a | 0 | 1 | 1 | 2 | 2 | 2 |
// t | 0 | 1 | 1 | 2 | 2 | 3 |
