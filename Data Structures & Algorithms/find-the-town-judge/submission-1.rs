impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        let n = n as usize;
        let mut delta = vec![0i32; n + 1];
        for t in &trust {
            delta[t[0] as usize] -= 1;
            delta[t[1] as usize] += 1;
        }
        for i in 1..=n {
            if delta[i] == n as i32 - 1 {
                return i as i32;
            }
        }
        -1
    }
}
