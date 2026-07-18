impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        let n = piles.len();
        let mut suffix_sum = vec![0i32; n + 1];
        for i in (0..n).rev() {
            suffix_sum[i] = suffix_sum[i + 1] + piles[i];
        }
        let mut memo = vec![vec![-1i32; n]; n];
        Self::dfs(&piles, &suffix_sum, 0, 1, &mut memo)
    }
    fn dfs(
        piles: &[i32], 
        suffix_sum: &[i32], 
        i: usize, 
        m: usize, 
        memo: &mut Vec<Vec<i32>>,
    ) -> i32 {
        let n = piles.len();
        // no more piles to play
        if i >= n {
            return 0;
        }
        // if we can take the rest we take those
        if i + 2 * m >= n {
            return suffix_sum[i];
        }

        if memo[i][m] != -1 {
            return memo[i][m];
        }

        let mut best = 0;
        for x in 1..=(2 * m) {
            if i + x > n { break;}
            let opponent = Self::dfs(piles, suffix_sum, i + x, m.max(x), memo);
            best = best.max(suffix_sum[i] - opponent);
        }
        memo[i][m] = best;
        best
    }
}
