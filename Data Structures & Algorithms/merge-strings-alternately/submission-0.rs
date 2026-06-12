impl Solution {
    pub fn merge_alternately(word1: String, word2: String) -> String {
        let w1: Vec<char> = word1.chars().collect();
        let w2: Vec<char> = word2.chars().collect();
        let (mut p1, mut p2) = (0, 0);
        let mut result = String::new();
        while p1 < w1.len() || p2 < w2.len() {
            if p1 < w1.len() {
                result.push(w1[p1]);
                p1 += 1;
            }
            if p2 < w2.len() {
                result.push(w2[p2]);
                p2 += 1;
            }
        }
        result
    }
}
