impl Solution {
    pub fn find_target_sum_ways(nums: Vec<i32>, target: i32) -> i32 {
        fn dfs(
            nums: &[i32], 
            target: i32, 
            index: usize, 
            curr_sum: i32, 
            memo: &mut HashMap<(usize, i32), i32>
        ) -> i32 {
            if index == nums.len() {
                if curr_sum == target {
                    return 1;
                }
                return 0;
            }

            if let Some(&val) = memo.get(&(index, curr_sum)) {
                return val;
            }
            let val = dfs(nums, target , index + 1, curr_sum - nums[index], memo) 
                    + dfs(nums, target, index + 1, curr_sum + nums[index], memo);
            memo.insert((index, curr_sum), val);
            val
        }
        let mut memo = Default::default();
        dfs(&nums, target, 0, 0, &mut memo)
    }
}
