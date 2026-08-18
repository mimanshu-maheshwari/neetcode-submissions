impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        let n = digits.len();
        if n == 0 {
            return vec![];
        }
        let chars: Vec<char> = digits.chars().collect();
        let digit_map = {
            let mut map = HashMap::new();
            map.insert('2', vec!['a', 'b', 'c']);
            map.insert('3', vec!['d', 'e', 'f']);
            map.insert('4', vec!['g', 'h', 'i']);
            map.insert('5', vec!['j', 'k', 'l']);
            map.insert('6', vec!['m', 'n', 'o']);
            map.insert('7', vec!['p', 'q', 'r', 's']);
            map.insert('8', vec!['t', 'u', 'v']);
            map.insert('9', vec!['w', 'x', 'y', 'z']);
            map
        };
        let mut parent_str = String::new();
        let mut result = Vec::new();
        Self::backtrack(&chars, &digit_map, 0, &mut parent_str, &mut result);
        result
    }
    fn backtrack(
        chars: &[char],
        digit_map: &HashMap<char, Vec<char>>,
        index: usize,
        parent_str: &mut String,
        result: &mut Vec<String>,
    ) {
        if index == chars.len() {
            result.push(parent_str.clone());
            return;
        }
        for c in &digit_map[&chars[index]] {
            parent_str.push(*c); 
            Self::backtrack(chars, digit_map, index + 1, parent_str, result);
            parent_str.pop();
        }
    }
}
