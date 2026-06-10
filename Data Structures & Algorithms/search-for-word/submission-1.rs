use std::collections::HashSet;
impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        let (rows, cols) = (board.len(), board[0].len());
        let word = word.chars().collect::<Vec<char>>();
        for row in 0..rows {
            for col in 0..cols {
                if board[row][col] != word[0] {
                    continue;
                }
                let mut set = HashSet::new();
                if Self::dfs(&board, (row, col), (rows, cols), &word, 0, &mut set) {
                    return true;
                }
            }
        }
        false
    }
    fn dfs(
        board: &[Vec<char>],
        (row, col): (usize, usize),
        (rows, cols) : (usize, usize),
        word: &[char],
        index: usize,
        visited: &mut HashSet<(usize, usize)>,
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
        visited.insert((row, col));
        for (nr, nc) in Self::neighbors((row, col), (rows, cols)) {
            if visited.contains(&(nr, nc)) {
                continue;
            }
            if wc == board[nr][nc] {
                if Self::dfs(board, (nr, nc), (rows, cols), word, i, visited) {
                    return true;
                }
            }
        }
        visited.remove(&(row, col));
        false
    }
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
