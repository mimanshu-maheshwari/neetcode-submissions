use std::collections::BinaryHeap;
use std::cmp::Reverse;

impl Solution {
    pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        let k = k as usize;
        let mut heap: BinaryHeap<(i32, &Vec<i32>)> = BinaryHeap::new();
        for point in points.iter() {
            heap.push((Self::dist(point), point));
            if heap.len() > k {
                heap.pop();
            }
        }
        heap.into_iter().map(|(val, point)| point.to_vec()).collect::<Vec<Vec<i32>>>()
    }

    fn dist(a: &[i32]) -> i32 {
        (0 - a[0]) * (0 - a[0]) + (0 - a[1]) * (0 - a[1])
    }
}
