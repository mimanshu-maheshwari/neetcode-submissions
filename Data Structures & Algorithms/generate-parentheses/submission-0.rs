impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        let mut result = Vec::new();
        let mut curr = String::new();
        Self::dfs(n as usize, 0, 0, &mut curr, &mut result);
        result
    }
    fn dfs(n: usize, open_count: usize, close_count: usize, curr_string: &mut String, result: &mut Vec<String>) {
        if open_count > n || close_count > open_count || curr_string.len() > 2 * n {
            return;
        }
        if open_count == close_count && curr_string.len() == 2 * n {
            result.push(curr_string.clone());
            return;
        }
        if open_count < n {
            curr_string.push('(');
            Self::dfs(n, open_count + 1, close_count, curr_string, result);
            curr_string.pop();
        }
        if close_count < open_count {
            curr_string.push(')');
            Self::dfs(n, open_count, close_count + 1, curr_string, result);
            curr_string.pop();
        }
    }
}
