impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        let mut result = Vec::new();
        let mut curr = Vec::new();
        let s = s.chars().collect::<Vec<char>>();
        Self::dfs(&s[..], 0, &mut curr, &mut result);
        result
    }

    fn dfs(s: &[char], index: usize, curr: &mut Vec<String>, result: &mut Vec<Vec<String>>) {
        // base condition 
        if index == s.len() {
            result.push(curr.clone());
            return;
        }
        // backtracking condition 
        for end in index..s.len() {
            if Self::is_palindrome(&s[index..=end]) {
                curr.push(s[index..=end].iter().collect::<String>());
                Self::dfs(s, end + 1, curr, result);
                curr.pop();
            }
        }
    }

    fn is_palindrome(s: &[char]) -> bool {
        if s.is_empty() {
            return true;
        }
        let (mut l, mut r) = (0, s.len() - 1);
        while l < r {
            if s[l] != s[r] {
                return false;
            }
            l += 1;
            r -= 1;
        }
        true
    }
}
