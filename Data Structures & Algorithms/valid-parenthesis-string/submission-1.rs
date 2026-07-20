impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        let (mut low, mut high) = (0i32, 0i32);
        
        for c in s.chars() {
            match c {
                '(' => {low += 1; high += 1;},
                '*' => {low -= 1; high += 1;},
                ')' => {low -= 1; high -= 1;},
                _ => unreachable!(),
            }
            if high < 0 { return false; }
            low = low.max(0);
        }
        low == 0

    }
}
