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

    pub fn dfs(
        coins: &[i32],
        target: i32,
        memo: &mut Vec<Option<i32>>,
    ) -> i32 {
        if target < 0 {
            return -1;
        }
        if target == 0 {
            return 0;
        }
        if let Some(val) = memo[target as usize] {
            return val;
        }
        let mut coin_count = i32::MAX;
        for coin in coins {
            let count = Self::dfs(coins, target - coin, memo);
            if count == -1 {
                continue;
            }
            coin_count = coin_count.min(count);
        }
        let val = if coin_count == i32::MAX {
            -1
        } else {
            coin_count + 1
        };
        memo[target as usize] = Some(val);
        val
    }
}
