impl Solution {
    pub fn decode_string(s: String) -> String {
        let len: usize = s.len();
        let mut stack: Vec<(String, usize)> = Vec::new();
        let mut curr_string: String = String::new();
        let mut curr_num: usize = 0;
        for &byte in s.as_bytes() {
            if byte >= b'a' as u8 && byte <= b'z' {
                curr_string.push(byte as char);
            } else if byte >= b'0' && byte <= b'9' {
                curr_num = curr_num * 10 + (byte - b'0') as usize;
            } else if byte == b'[' {
                stack.push((curr_string.clone(), curr_num.clone()));
                curr_string = String::new();
                curr_num = 0;
            } else if byte == b']' {
                if let Some((mut pre_string, num)) = stack.pop() {
                    curr_string = curr_string.repeat(num);
                    pre_string.push_str(&curr_string);
                    curr_string = pre_string;
                }
            }
        }
        while let Some((mut pre_string, num)) = stack.pop() {
            curr_string = curr_string.repeat(num);
            pre_string.push_str(&curr_string);
            curr_string = pre_string;
        }
        curr_string
    }
}
