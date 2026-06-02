impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        let mut output = String::new();
        for s in &strs {
            output.push_str(&s.len().to_string());
            output.push('#');
            output.push_str(s);
        }
        output
    }

    pub fn decode(s: String) -> Vec<String> {
        let chars: Vec<char> = s.chars().collect();
        let mut index = 0;
        let mut result = Vec::new();
        while index < chars.len() {
            let mut num = 0;
            while chars[index] as u8 != b'#' {
                num = num * 10 + ((chars[index] as u8 - b'0')as usize);
                index += 1;
            }
            index += 1;
            let string = chars[(index)..(index + num)].iter().collect::<String>();
            result.push(string);
            index += num;
        }
        result
    }
}
