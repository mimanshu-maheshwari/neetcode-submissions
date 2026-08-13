use std::collections::{BinaryHeap, HashMap};

impl Solution {
    pub fn network_delay_time(times: Vec<Vec<i32>>, n: i32, k: i32) -> i32 {
        const INF: i32 = 1001;
        let k = k as usize;
        let n = n as usize;
        let mut edges: HashMap<usize, Vec<(usize, i32)>> = HashMap::new();
        for time in &times {
            let (u, v, t) = (time[0] as usize, time[1] as usize, time[2]);
            edges.entry(u).or_default().push((v, t));
        }
        let mut min_heap = BinaryHeap::new();
        min_heap.push(Reverse((0i32, k as usize)));
        let mut visited = HashSet::new();
        let mut t = 0;

        while let Some(Reverse((w1, n1))) = min_heap.pop() {
            if !visited.insert(n1) {
                continue;
            }
            t = w1;
            if let Some(neighbors) = edges.get(&n1) {
                for &(n2, w2) in neighbors {
                    if !visited.contains(&n2) {
                        min_heap.push(Reverse((w1 + w2, n2)));
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
