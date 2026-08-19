impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let n = prices.len();
        let mut l = 0;
        let mut max_profit = 0;
        for (r, &price) in prices.iter().enumerate() {
            if  price < prices[l] {
                l = r;
            }
            max_profit = max_profit.max(price - prices[l]);
        }
        max_profit
    }
}
