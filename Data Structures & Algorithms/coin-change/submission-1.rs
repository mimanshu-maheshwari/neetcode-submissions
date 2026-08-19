impl Solution {
    pub fn coin_change(coins: Vec<i32>, amount: i32) -> i32 {
        if amount < 0 {
            return -1;
        }
        if amount == 0 {
            return 0;
        }
        let mut memo = vec![None; amount as usize + 1];
        Self::dfs(&coins, amount, &mut memo)
    }
    fn dfs(coins: &[i32], target: i32, memo: &mut Vec<Option<i32>>) -> i32 {
        if target == 0 { return 0; }
        if target < 0 { return -1; }
        if let Some(val) = memo[target as usize] { return val; }
        let result = coins.iter()
            .filter_map(|&c| {
                let sub = Self::dfs(coins, target - c, memo);
                if sub >= 0 { Some(sub + 1) } else { None }
            })
            .min()
            .unwrap_or(-1);
        memo[target as usize] = Some(result);
        result
    }

}
