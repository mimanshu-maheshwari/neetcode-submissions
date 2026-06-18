use std::collections::HashMap;

#[derive(Debug, Default)]
struct TrieNode {
    children: HashMap<char, TrieNode>, 
    word: Option<String>,
}

impl Solution {
    pub fn find_words(mut board: Vec<Vec<char>>, words: Vec<String>) -> Vec<String> {
        let edges = (board.len(), board[0].len());
        let mut result = Vec::new();
        let mut root = TrieNode::default();
        for word in &words {
            let mut node = &mut root;
            for ch in word.chars() {
                node = node.children.entry(ch).or_default();
            }
            node.word = Some(word.to_owned());
        }

        for row in 0..edges.0 {
            for col in 0..edges.1 {
                Self::dfs(&mut board, edges, row, col, &mut root, &mut result);
            }
        }

        result
    }

    fn dfs(
        board: &mut Vec<Vec<char>>, 
        edges: (usize, usize), 
        row: usize, 
        col: usize, 
        node: &mut TrieNode, 
        result: &mut Vec<String>
    ) {
        let curr_ch = board[row][col];
        if curr_ch == '#' {
            return;
        }

        let Some(next) = node.children.get_mut(&curr_ch) else {return ;};
        // it is pushed once should not be pushed again 
        // so we take it and replace it with None
        if let Some(word) = next.word.take() {
            result.push(word);
        }

        // mark it as visited
        board[row][col] = '#';

        for (r, c) in Self::neighbors((row, col), edges) {
            Self::dfs(board, edges, r, c, next, result);
        }

        // revert
        board[row][col] = curr_ch;

    }

    fn neighbors(
        (row, col): (usize, usize), 
        (rows, cols): (usize, usize)
    ) -> impl Iterator<Item = (usize, usize)> {
        let mut result = Vec::new();
        if row > 0 {
            result.push((row - 1, col));
        }
        if col > 0 {
            result.push((row, col - 1));
        }
        if row + 1 < rows {
            result.push((row + 1, col));
        }
        if col + 1 < cols {
            result.push((row, col + 1));
        }
        result.into_iter()
    }
}

