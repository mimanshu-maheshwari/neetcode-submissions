impl Solution {
    pub fn min_end(n: i32, x: i32) -> i64 {
        let mut res = x as i64;
        let mut m = (n - 1) as i64;  // counter value for the last element
        let x = x as i64;
        let mut bit = 1i64;
        while m > 0 {
            if bit & x == 0 {  // this is a free bit position
                if m & 1 == 1 {        // corresponding bit of counter is 1
                    res |= bit;
                }
                m >>= 1;               // consume one bit of the counter
            }
            bit <<= 1;                 // advance to next position
        }
        res
    }
}