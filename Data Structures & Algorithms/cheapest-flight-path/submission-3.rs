impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        let src = src as usize;
        let dst = dst as usize;
        let k = k as usize;
        let n = n as usize;
        let mut prices = vec![i32::MAX; n];
        prices[src] = 0;
        for i in 0..(k+1) {
            let mut temp_prices = prices.clone();
            for flight in &flights {
                let from = flight[0] as usize;
                let to = flight[1] as usize;
                let p = flight[2];
                if prices[from] == i32::MAX {
                    continue;
                }
                if prices[from] + p < temp_prices[to] {
                    temp_prices[to] = prices[from] + p;
                }
            }
            prices = temp_prices;
        }
        if prices[dst] == i32::MAX {-1} else {prices[dst]}
    }
}
