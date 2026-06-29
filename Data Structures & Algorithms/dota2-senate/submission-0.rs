use std::collections::VecDeque;

impl Solution {
    pub fn predict_party_victory(senate: String) -> String {
        let mut r = VecDeque::new();
        let mut d = VecDeque::new();
        let n = senate.len();
        for (i, c) in senate.chars().enumerate() {
            if c == 'R' {
                r.push_back(i);
            } else {
                d.push_back(i);
            }
        }
        while !r.is_empty() && !d.is_empty() {
            let r_turn = r.pop_front().unwrap();
            let d_turn = d.pop_front().unwrap();
            if r_turn < d_turn {
                r.push_back(r_turn + n);
            } else {
                d.push_back(d_turn + n);
            }
        }
        if r.is_empty() {
            "Dire".to_string()
        } else {
            "Radiant".to_string()
        }
    }
}
