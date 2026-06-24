impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        let mut data = Vec::new();
        for op in operations {
            let op = op.as_str();
            match op {
                "+" => {
                    data.push(data[data.len() - 1] + data[data.len() - 2]);
                },
                "D" => {
                    data.push(data[data.len() - 1] * 2);
                },
                "C" => {
                    data.pop();
                },
                num_str => {
                    let mut sign = 1i32;
                    let num_chars = num_str.chars().collect::<Vec<char>>();
                    let mut start = 0usize;
                    if num_chars[0] == '-' {
                        sign = -1;
                        start = 1;
                    }
                    let mut num = 0i32;
                    for i in start..num_chars.len() {
                        let digit = (num_chars[i] as u8 - b'0') as i32;
                        num = (num * 10) + digit;
                    }
                    data.push(num * sign);
                }
            }
        }
        data.into_iter().sum()
    }
}
