impl Solution {
    pub fn min_end(n: i32, x: i32) -> i64 {
        let mut res = x as i64; 
        for _ in 0..n - 1 {
            res = (res + 1) | x as i64;
        }
        res
    }
}
