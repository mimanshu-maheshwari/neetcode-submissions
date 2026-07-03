impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        let mut count: i32 = 0;
        let s: Vec<char> = s.chars().collect();
        for i in 0..s.len() {
            count += Self::is_palindrome(&s, i, i);
            if (i > 0) {
                count += Self::is_palindrome(&s, i - 1, i);
            }
        }
        count
    }

    fn is_palindrome(s: &[char], mut start: usize, mut end: usize) -> i32 {
        let mut count = 0;
        while start >= 0 && end < s.len() {
            if s[start] != s[end] {
                break;
            }
            count += 1;
            if (start == 0 || end == s.len()){
                break;
            }
            start -= 1;
            end   += 1;
        }
        count
    }
}
