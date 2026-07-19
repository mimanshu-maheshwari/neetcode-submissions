impl Solution {

    pub fn is_interleave(s1: String, s2: String, s3: String) -> bool {
        let s1: Vec<char> = s1.chars().collect();
        let s2: Vec<char> = s2.chars().collect();
        let s3: Vec<char> = s3.chars().collect();
        if s1.len() + s2.len() != s3.len() {
            return false;
        }
        let mut memo: Vec<Vec<Option<bool>>> = vec![vec![None; s2.len() + 1]; s1.len() + 1];
        Self::dfs(&s1, &s2, &s3, 0, 0, &mut memo)
    }

    fn dfs(
        s1: &[char], 
        s2: &[char], 
        s3: &[char], 
        p1: usize, 
        p2: usize, 
        memo: &mut Vec<Vec<Option<bool>>>,
    ) -> bool {
        if p1 + p2 == s3.len() {
            return true;
        }
        
        if p1 + p2 > s3.len() {
            return false;
        }

        if let Some(val) = memo[p1][p2] {
            return val;
        }

        if p1 < s1.len() && s1[p1] == s3[p1 + p2] {
            let val =  Self::dfs(s1, s2, s3, p1 + 1, p2, memo);
            memo[p1][p2] = Some(val);
            if val {
                return true;
            }
        }

        if p2 < s2.len() && s2[p2] == s3[p1 + p2] {
            let val = Self::dfs(s1, s2, s3, p1, p2 + 1, memo);
            memo[p1][p2] = Some(val);
            if val {
                return true;
            }

        }

        memo[p1][p2] = Some(false);
        false
    }
}
