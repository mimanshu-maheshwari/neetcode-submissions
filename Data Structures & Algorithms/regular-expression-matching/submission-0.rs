impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        return Self::dfs(&s, &p, 0, 0);
    }
    fn dfs(s: &[char], p: &[char], i: usize, j: usize) -> bool {
        if i >= s.len() && j >= p.len() {
            return true;
        }
        if j >= p.len() {
            return false;
        }
        let same: bool = i < s.len() && (s[i] == p[j] || p[j] == '.');
        if j + 1 < p.len() && p[j + 1] == '*' {
            return Self::dfs(s, p, i, j + 2) || (same && Self::dfs(s, p, i + 1, j));
        }
        if same {
            return Self::dfs(s, p, i + 1, j + 1);
        }
        false
    }
}
