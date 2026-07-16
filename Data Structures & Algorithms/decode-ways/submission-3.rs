impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        let chars: Vec<u8> = s.bytes().collect();
        let n = chars.len();

        let (mut prev2, mut prev1) = (1i32, if chars[0] == b'0' {0i32} else {1i32});

        for i in 1..n {
            let mut curr = 0;
            if chars[i] != b'0' {
                curr += prev1;
            }
            let two_digits = (chars[i - 1] - b'0') * 10 + (chars[i] - b'0');
            if two_digits >= 10 && two_digits <= 26 {
                curr+= prev2
            }
            prev2 = prev1;
            prev1 = curr;
        }


        prev1

    }
}
