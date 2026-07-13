impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        let n = 9;
        // validate the cols and validate the rows
        for row in 0..n {
            let mut rowbitset= 0u16;
            let mut colbitset= 0u16;
            for col in 0..n {
                if board[row][col] != '.' {
                    if check_bit(rowbitset, board[row][col]) {
                        return false;
                    }
                    set_bit(&mut rowbitset, board[row][col]);
                }
                if board[col][row] != '.' {
                    if check_bit(colbitset, board[col][row]) {
                        return false;
                    }
                    set_bit(&mut colbitset, board[col][row]);
                }
            }
        }
        // validate boxes
        for square in 0..9 {
            let mut bitset = 0u16;
            for i in 0..3 {
                for j in 0..3 {
                    let row = (square / 3) * 3 + i;
                    let col = (square % 3) * 3 + j;
                    if board[row][col] == '.' {
                        continue;
                    }
                    if check_bit(bitset, board[row][col]) {
                        return false;
                    }
                    set_bit(&mut bitset, board[row][col]);
                }
            }
        }
        true
    }
}


#[inline(always)]
fn set_bit(bitset: &mut u16, val: char) {
    let mut val = ((val as u8) - b'0') as usize;
    *bitset |= 1 << val;
}

#[inline(always)]
fn check_bit(bitset: u16, val: char) -> bool {
    let mut val = ((val as u8) - b'0') as usize;
    (bitset >> val) & 1 == 1
}