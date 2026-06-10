impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        let mut res = Vec::new();
        let directions = [(0i32, 1i32), (1, 0), (0, -1), (-1, 0)];
        let mut steps = [matrix[0].len() as i32, matrix.len() as i32 - 1];

        let (mut r, mut c, mut d) = (0i32, -1i32, 0usize);
        while steps[d & 1] > 0 {
            for _ in 0..steps[d & 1] {
                r += directions[d].0;
                c += directions[d].1;
                res.push(matrix[r as usize][c as usize]);
            }
            steps[d & 1] -= 1;
            d = (d + 1) % 4;
        }
        res
    }
}