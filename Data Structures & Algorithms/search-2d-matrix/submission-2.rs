impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let m = matrix.len();
        let n = matrix[0].len();
        let (mut r, mut c) = (0, n as i32 - 1);

        while r < m as i32 && c >= 0 {
            if matrix[r as usize][c as usize] > target {
                c -= 1;
            } else if matrix[r as usize][c as usize] < target {
                r += 1;
            } else {
                return true;
            }
        }
        false
    }
}