impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        let n = s.len();
        let chars: Vec<char> = s.chars().collect();
        let mut p_stack = Vec::new();
        let mut s_stack = Vec::new();
        for (i, &c) in chars.iter().enumerate() {
            match c {
                '(' => p_stack.push(i),
                '*' => s_stack.push(i), 
                ')' => {
                    if !p_stack.is_empty() {
                        p_stack.pop();
                    } else if !s_stack.is_empty() {
                        s_stack.pop();
                    } else {
                        return false;
                    }
                }, 
                _ => unreachable!()
            }
        }
        while let Some(pi) = p_stack.pop() {
            if let Some(si) = s_stack.pop() {
                if pi > si {
                    return false;
                }
            } else {
                return false;
            }
        }
        true
    }
}
