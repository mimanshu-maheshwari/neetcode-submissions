use std::collections::HashMap;

impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        let mut memo = HashMap::new();
        return Self::dfs(&s, &p, 0, 0, &mut memo);
    }

    fn dfs(s: &[char], p: &[char], i: usize, j: usize, memo: &mut HashMap<(usize, usize), bool>) -> bool {
        if memo.contains_key(&(i, j)) {
            return memo[&(i, j)];
        }
        if i >= s.len() && j >= p.len() {
            return true;
        }
        if j >= p.len() {
            return false;
        }
        let same: bool = i < s.len() && (s[i] == p[j] || p[j] == '.');
        if j + 1 < p.len() && p[j + 1] == '*' {
            let val = Self::dfs(s, p, i, j + 2, memo) || (same && Self::dfs(s, p, i + 1, j, memo));
            memo.insert((i, j), val);
            return memo[&(i, j)];
        }
        if same {
            let val = Self::dfs(s, p, i + 1, j + 1, memo);
            memo.insert((i, j), val);
            return memo[&(i, j)];
        }
        false
    }
}
