impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        let mut rows = [0i32; 9];
        let mut cols = [0i32; 9];
        let mut squares = [0i32; 9];

        for r in 0..9 {
            for c in 0..9 {
                if board[r][c] == '.' { continue; }

                let val = board[r][c] as i32 - '1' as i32;
                let bit = 1 << val;
                let square_idx = (r / 3) * 3 + c / 3;

                if (rows[r] & bit) != 0
                    || (cols[c] & bit) != 0
                    || (squares[square_idx] & bit) != 0
                {
                    return false;
                }

                rows[r] |= bit;
                cols[c] |= bit;
                squares[square_idx] |= bit;
            }
        }

        true
    }
}