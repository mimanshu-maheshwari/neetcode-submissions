impl Solution {
    pub fn num_squares(mut n: i32) -> i32 {
        let is_square = |x: i32| -> bool {
            let s = (x as f64).sqrt() as i32;
            s * s == x
        };
        while n % 4 == 0 {
            n /= 4;
        }
        if n % 8 == 7 {
            return 4;
        }
        if is_square(n) {
            return 1;
        }
        let mut i = 1;
        while i * i <= n {
            if is_square(n - i * i) {
                return 2;
            }
            i += 1;
        }
        3
    }
}