impl Solution {
    pub fn reverse(x: i32) -> i32 {
        let mut n = x.abs();
        let mut result = 0_i32;
        while n > 0 {
            if let Some(val) = result.checked_mul(10) {
                if let Some(a) = val.checked_add(n % 10) {
                    result = a;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
            n /= 10;
        }

        if x > 0 {
            result
        } else {
            result * -1
        }
    }
}
