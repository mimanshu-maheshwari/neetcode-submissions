use std::collections::{HashSet, HashMap, BinaryHeap};
impl Solution {
    pub fn network_delay_time(times: Vec<Vec<i32>>, n: i32, k: i32) -> i32 {
        let n = n as usize;
        let start = k as usize;

        let mut adj: HashMap<usize, Vec<(usize, i32)>> = HashMap::new();
        for time in &times {
            let (u, v, t) = (time[0] as usize, time[1] as usize, time[2]);
            adj.entry(u).or_default().push((v, t));
        }
        let mut min_heap = BinaryHeap::new();
        min_heap.push(Reverse((0i32, start)));
        let mut visited = HashSet::new();
        // total time if all nodes are visited
        let mut t = 0;
        while let Some(Reverse((wi, ni))) = min_heap.pop() {
            if !visited.insert(ni) {
                continue;
            }
            t = wi;
            if let Some(list) = adj.get(&ni) {
                for (nexti, nextw) in list {
                    if !visited.contains(nexti) {
                        min_heap.push(Reverse((nextw + wi, *nexti)));
                    }
                }
            }
        }
        if visited.len() == n {
            t
        } else {
            -1
        }
    }
}
