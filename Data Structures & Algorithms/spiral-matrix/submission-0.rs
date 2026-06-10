impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        let (rows, cols) = (matrix.len(), matrix[0].len());
        let mut result = Vec::new();
        let (mut row, mut col);
        let (mut top, mut left, mut right, mut bottom) = (0, 0, cols - 1, rows - 1);
        while result.len() < rows * cols {
            // move from left to right
            row = top;
            col = left;
            while col <= right {
                result.push(matrix[row][col]);
                col += 1;
            }
            top += 1;
            if top > bottom {
                break;
            }
            // move from top to bottom 
            row = top;
            col = right;
            while row <= bottom {
                result.push(matrix[row][col]);
                row += 1;
            }
            if let Some(val) = right.checked_sub(1) {
                right = val;
            } else {
                break;
            }
            if left > right {
                break;
            }
            // move from right to left
            row = bottom;
            col = right;
            while col >= left {
                result.push(matrix[row][col]);
                if let Some(val) = col.checked_sub(1) {
                    col = val;
                } else {
                    break;
                }
            }

            if let Some(val) = bottom.checked_sub(1) {
                bottom = val;
            } else {
                break;
            }
            if top > bottom {
                break;
            }
            // move from bottom to up
            row = bottom;
            col = left;
            while row >= top {
                result.push(matrix[row][col]);
                if let Some(val) = row.checked_sub(1) {
                    row = val;
                } else {
                    break;
                }
            }
            left += 1;
            if (left > right) {
                break;
            }
        }
        result
    }
}
