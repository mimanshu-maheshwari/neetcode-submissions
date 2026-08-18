impl Solution{
    pub fn roman_to_int(s: String) -> i32 {
        let val = |c| match c {
            'I' => 1, 'V' => 5, 'X' => 10, 'L' => 50,
            'C' => 100, 'D' => 500, 'M' => 1000, _ => 0,
        };
        let chars: Vec<char> = s.chars().collect();
        let mut result = 0;
        for i in 0..chars.len() {
            let curr = val(chars[i]);
            let next = if i + 1 < chars.len() { val(chars[i+1]) } else { 0 };
            if curr < next { result -= curr; } else { result += curr; }
        }
        result
    }
}