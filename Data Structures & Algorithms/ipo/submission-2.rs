use std::collections::BinaryHeap;
use std::cmp::Reverse;
impl Solution {
    pub fn find_maximized_capital(k: i32, mut w: i32, profits: Vec<i32>, capital: Vec<i32>) -> i32 {
        let n = profits.len();
        let mut max_profit : BinaryHeap<i32> = BinaryHeap::new();
        let mut min_capital: BinaryHeap<Reverse<(i32, i32)>>   = BinaryHeap::new();

        for i in 0..n {
            min_capital.push(Reverse((capital[i], profits[i])));
        }

        for i in 0..k {

            while min_capital.peek().is_some_and(|val| val.0.0 <= w) {
                let Reverse((c, p)) = min_capital.pop().unwrap();
                max_profit.push(p);
            }

            if let Some(val) = max_profit.pop() {
                w += val;
            } else {
                break;
            }
        }
        w
    }
}
