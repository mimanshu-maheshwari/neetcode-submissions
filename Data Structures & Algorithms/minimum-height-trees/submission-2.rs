impl Solution {
    pub fn find_min_height_trees(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        let n = n as usize;
        if n == 1 { 
            return vec![0];
        }
        let mut adj = vec![std::collections::HashSet::new(); n];
        for edge in &edges {
            let (a, b) = (edge[0] as usize, edge[1] as usize);
            adj[a].insert(b);
            adj[b].insert(a);
        }

        let mut leaves: std::collections::VecDeque<usize> = (0..n)
            .filter(|&i| adj[i].len() == 1)
            .collect(); 

        let mut remaining = n;
        while remaining > 2 {
            let leaves_count = leaves.len();
            remaining -= leaves_count;
            for _ in 0..leaves_count {
                // SAFETY: For loop confirms there are elements in queue
                let leaf = leaves.pop_front().unwrap();
                // there should be atleast 1 connection as this is a valid tree and we only add leaves where only one connection is left
                let neighbor = *adj[leaf].iter().next().unwrap(); 
                adj[neighbor].remove(&leaf);

                if adj[neighbor].len() == 1 {
                    leaves.push_back(neighbor);
                }
            }
        }
        leaves.into_iter().map(|i| i as i32).collect()
    }
}
