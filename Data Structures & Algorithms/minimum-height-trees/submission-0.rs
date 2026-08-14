use std::collections::{VecDeque, HashSet, HashMap};
impl Solution {
    pub fn find_min_height_trees(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        let n = n as usize;
        let adj = {
            let mut a: HashMap<usize, Vec<usize>> = HashMap::new();
            for edge in &edges {
                let (ai,bi) = (edge[0] as usize, edge[1] as usize);
                a.entry(ai).or_default().push(bi);
                a.entry(bi).or_default().push(ai);
            }
            a
        };
        let mut min = n as i32;
        let mut heights = vec![n as i32; n];
        for node in 0..n {
            heights[node] = Self::tree_height(&adj, node);
            min = min.min(heights[node]);
        }
        let mut result = Vec::new();
        for node in 0..n {
            if heights[node] == min {
                result.push(node as i32);
            }
        }
        result
    }

    fn tree_height(adj: &HashMap<usize, Vec<usize>>, start: usize) -> i32 {
        let mut height = 0;
        let mut visited = HashSet::new();
        let mut queue = VecDeque::new();
        queue.push_back(start);
        while !queue.is_empty() {
            let size = queue.len();
            height += 1;
            for _ in 0..size {
                let Some(node) = queue.pop_front() else { unreachable!();};
                if !visited.insert(node) {
                    continue;
                }
                if let Some(list) = adj.get(&node) {
                    for next in list {
                        if !visited.contains(next) {
                            queue.push_back(*next);
                        }
                    }
                }
            }
        }
        height
    }
}
