impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        let map = {
            let mut map = HashMap::new();
            map.insert("I"  , 1i32);
            map.insert("IV" , 4);
            map.insert("V"  , 5);
            map.insert("IX" , 9);
            map.insert("X"  , 10);
            map.insert("XL" , 40);
            map.insert("L"  , 50);
            map.insert("XC" , 90);
            map.insert("C"  , 100);
            map.insert("CD" , 400);
            map.insert("D"  , 500);
            map.insert("CM" , 900);
            map.insert("M"  , 1000);
            map
        };
        let s: Vec<char> = s.chars().collect();
        let mut i = 0usize;
        let mut result = 0i32;
        while i < s.len() {
            let mut roman = String::new();
            roman.push(s[i]);
            i += 1;
            if i < s.len() {
                roman.push(s[i]);
                if let Some(val) = map.get(roman.as_str()) {
                    result += val;
                    i += 1;
                    continue;
                }
                roman.pop();
            }
            if let Some(val) = map.get(roman.as_str()) {
                result += val;
            }
        }
        result
    }
}
