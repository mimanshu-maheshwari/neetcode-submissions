impl Solution {
    pub fn combination_sum2(mut candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        candidates.sort_unstable();
        let mut result = Vec::new();
        let mut combination = Vec::new();
        Self::dfs(&candidates, target, 0, &mut combination, &mut result);
        result
    }

    #[inline(always)]
    fn dfs(
        candidates: &[i32], 
        target: i32, 
        index: usize,
        combination: &mut Vec<i32>, 
        result: &mut Vec<Vec<i32>>,
    ) {
        if target == 0 {
            result.push(combination.clone());
            return;
        }
        for i in index..candidates.len() {
            if candidates[i] > target { break; }
            if i > index && candidates[i] == candidates[i - 1] { continue; }
            combination.push(candidates[i]);
            Self::dfs(&candidates, target - candidates[i], i + 1, combination, result);
            combination.pop();
        }
    }
}
