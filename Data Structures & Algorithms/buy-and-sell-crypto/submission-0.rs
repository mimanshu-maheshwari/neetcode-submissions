impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let n = prices.len();
        let mut l = 0;
        let mut max_profit = 0;
        for (r, &price) in prices.iter().enumerate() {
            let mut curr_profit = price - prices[l];
            max_profit = max_profit.max(curr_profit);
            while curr_profit < 0 && l < r {
                l += 1;
                curr_profit = price - prices[l];
            }
            max_profit = max_profit.max(curr_profit);
        }
        max_profit
    }
}
