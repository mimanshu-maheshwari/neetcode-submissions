use std::collections::HashSet;
impl Solution {
    pub fn exist(mut board: Vec<Vec<char>>, word: String) -> bool {
        let (rows, cols) = (board.len(), board[0].len());
        let word = word.chars().collect::<Vec<char>>();
        for row in 0..rows {
            for col in 0..cols {
                if board[row][col] != word[0] {
                    continue;
                }
                if Self::dfs(&mut board, (row, col), (rows, cols), &word, 0) {
                    return true;
                }
            }
        }
        false
    }

    #[inline]
    fn dfs(
        board: &mut [Vec<char>],
        (row, col): (usize, usize),
        (rows, cols) : (usize, usize),
        word: &[char],
        index: usize,
    ) -> bool {
        if index == word.len() - 1 {
            if board[row][col] == word[index] {
                return true;
            } else {
                return false;
            }
        }
        let i = index + 1;
        let wc = word[i];
        let backup = board[row][col];
        board[row][col] = '#';
        for (nr, nc) in Self::neighbors((row, col), (rows, cols)) {
            if wc == board[nr][nc] {
                if Self::dfs(board, (nr, nc), (rows, cols), word, i) {
                    return true;
                }
            }
        }
        board[row][col] = backup;
        false
    }
    #[inline]
    fn neighbors((row, col): (usize, usize), (rows, cols): (usize, usize)) -> impl Iterator<Item = (usize, usize)> {
        let mut result = Vec::new();
        if row + 1 < rows {
            result.push((row + 1, col));
        }
        if col + 1 < cols {
            result.push((row, col + 1));
        }
        if row > 0 {
            result.push((row - 1, col));
        }
        if col > 0 {
            result.push((row, col - 1));
        }
        result.into_iter()
    }
}
