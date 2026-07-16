impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        let chars: Vec<char> = s.chars().collect();
        if chars[0] == '0' {
            return 0i32;
        }
        let mut memo = vec![-1; chars.len()];
        Self::dfs(&chars, 0, &mut memo)
    }
    fn dfs(chars: &[char], index: usize, memo: &mut Vec<i32>) -> i32 {
        // base condition 
        if index >= chars.len() {
            return 1i32;
        }
        if chars[index] == '0' {
            return 0i32;
        }
        if memo[index] != -1 {
            return memo[index];
        }
        let mut count = 0i32;
        // recursive condition
        // take 1
        count += Self::dfs(chars, index + 1, memo);
        // take 2
        if index + 1 < chars.len() {
            let char1 = chars[index] as u8 - b'0';
            let char2 = chars[index + 1] as u8 - b'0';
            let num = char1 * 10 + char2;
            // println!("{num}");
            if num <= 26 {
                count += Self::dfs(chars, index + 2, memo);
            }
        }
        memo[index] = count;
        count
    }
}
