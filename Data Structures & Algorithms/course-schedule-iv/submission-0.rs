impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        let n = num_courses as usize;
        let mut reach = vec![vec![false; n]; n];
        
        for p in prerequisites {
            reach[p[0] as usize][p[1] as usize] = true;
        }
        
        for k in 0..n {
            for i in 0..n {
                for j in 0..n {
                    reach[i][j] |= reach[i][k] && reach[k][j];
                }
            }
        }
        queries
            .into_iter()
            .map(|q| reach[q[0] as usize][q[1] as usize])
            .collect()
    }
}
