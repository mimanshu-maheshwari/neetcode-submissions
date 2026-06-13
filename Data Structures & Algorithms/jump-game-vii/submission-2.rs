impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        let s: Vec<char> = s.chars().collect();
        let n = s.len() as i32;
        let mut dp = vec![false; n as usize];
        dp[0] = true;
        for i in 1..n {
            if s[i as usize] == '1' || i < min_jump {
                continue;
            }

            let start = (i - max_jump).max(0);
            let end = i - min_jump;
            for j in start..=end {
                if dp[j as usize] {
                    dp[i as usize] = true;
                    break;
                }
            }
        }
        dp[(n - 1) as usize]
    }
}
