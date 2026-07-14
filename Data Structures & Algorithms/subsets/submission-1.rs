impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut result = Vec::new();
        let mut curr = Vec::new();
        dfs(&nums, 0, &mut result, &mut curr);
        result
    }

}

#[inline(always)]
fn dfs(nums: &[i32], index: usize, result: &mut Vec<Vec<i32>>, curr_result: &mut Vec<i32>) {
    if index == nums.len() {
        result.push(curr_result.clone());
        return;
    }
    // recurse
    dfs(nums, index + 1, result, curr_result);
    // add current index
    curr_result.push(nums[index]);
    // recurse
    dfs(nums, index + 1, result, curr_result);
    // pop
    curr_result.pop();
}