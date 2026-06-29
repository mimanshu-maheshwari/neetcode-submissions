impl Solution {
    pub fn predict_party_victory(senate: String) -> String {
        let mut s = senate.chars().collect::<Vec<char>>();
        let mut count = 0;
        let mut i = 0;
        while i < s.len() {
            let c = s[i];

            if c == 'R' {
                if count < 0 {
                    s.push('D');
                }
                count += 1;
            } else {
                if count > 0 {
                    s.push('R');
                }
                count -= 1;
            }
            i += 1;
        }
        if count > 0 {
            "Radiant".to_string()
        } else {
            "Dire".to_string()
        }
    }
}
