use std::collections::{HashMap, BinaryHeap};
impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut freq_map: HashMap<i32, i32> = HashMap::new();
        let k: usize = k as usize;
        for num in nums {
            *freq_map.entry(num).or_insert(0) += 1;
        }
        let mut min_heap: BinaryHeap<(Reverse<i32>, i32)> = BinaryHeap::new();

        for (num, freq) in freq_map {
            min_heap.push((Reverse(freq), num));
            if min_heap.len() > k {
                min_heap.pop();
            }
        }
        min_heap.into_iter().map(|(_, num)| num).collect::<Vec<i32>>()
    }
}
