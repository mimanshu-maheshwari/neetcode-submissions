use std::collections::{HashMap, BinaryHeap};
impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut freq_map = HashMap::new();
        for &num in nums.iter() {
            freq_map.entry(num).and_modify(|v| *v += 1).or_insert(1);
        }
        let mut min_heap = BinaryHeap::new();

        for (num, freq) in freq_map {
            min_heap.push((Reverse(freq), num));
            if min_heap.len() > k as usize {
                min_heap.pop();
            }
        }
        min_heap.into_iter().map(|(_, num)| num).collect::<Vec<i32>>()
    }
}
