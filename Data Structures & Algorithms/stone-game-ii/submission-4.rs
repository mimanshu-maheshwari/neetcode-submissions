impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        let n = piles.len();
        let suffix = {
            let mut s = vec![0; n + 1];
            for i in (0..n).rev() {
                s[i] = s[i + 1] + piles[i];
            }
            s
        };
        let mut memo = vec![vec![-1i32; n]; n];
        Self::dfs(&piles, &suffix, 0, 1, &mut memo)
    }

    fn dfs(
        piles: &[i32], 
        suffix: &[i32],
        i: usize, 
        m: usize,
        memo: &mut Vec<Vec<i32>>,
    ) -> i32 {
        let n = piles.len();
        if i >= n {
            return 0;
        }

        if i + 2 * m >= n {
            return suffix[i];
        }

        if memo[i][m] != -1 {
            return memo[i][m];
        }

        let mut best = 0;
        for k in 1..=(2 * m) {
            if i + k > n { break;}
            let opponent = Self::dfs(piles, suffix, i + k, m.max(k), memo);
            best = best.max(suffix[i] - opponent);
        }
        memo[i][m] = best;
        best
    }
}
