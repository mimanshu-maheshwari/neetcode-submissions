impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let (rows, cols) = (matrix.len(), matrix[0].len());
        // find the row first
        let mut row = None;
        let (mut l, mut r) = (0, rows - 1);
        while (l <= r) {
            let mid = l + ((r - l) >> 1);
            if (target < matrix[mid][0]) {
                r = mid - 1;
                if (r > rows - 1) {
                    return false;
                }
            } else if (target > matrix[mid][cols - 1]) {
                l = mid + 1;
            } else {
                row = Some(mid);
                break;
            }
        }
        if let Some(row) = row {
            let (mut l, mut r) = (0, cols - 1);
            while (l <= r) {
                let mid = l + ((r - l) >> 1);
                if (target < matrix[row][mid]) {
                    r = mid - 1;
                    if (r > cols - 1) {
                        return false;
                    }
                } else if (target > matrix[row][mid]) {
                    l = mid + 1;
                } else {
                    return true;
                }
            }
        }
        false
        // find the col then
    }
}
