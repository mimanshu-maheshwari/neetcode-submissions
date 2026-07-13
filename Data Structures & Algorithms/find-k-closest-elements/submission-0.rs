use std::collections::BinaryHeap;
impl Solution {
    pub fn find_closest_elements(arr: Vec<i32>, k: i32, x: i32) -> Vec<i32> {
        // (dist, element)
        let mut max_heap: BinaryHeap<(i32, i32)> = BinaryHeap::new();
        let k: usize = k as usize;
        for num in arr {
            let dist = (x - num).abs();
            max_heap.push((dist, num));
            if max_heap.len() > k {
                max_heap.pop();
            }
        }
        let mut result = Vec::with_capacity(k);
        while let Some((_, num)) = max_heap.pop() {
            result.push(num);
        }
        result.sort_unstable();
        result
    }
}
