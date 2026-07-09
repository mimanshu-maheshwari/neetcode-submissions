use std::cmp::Reverse;
use std::collections::BinaryHeap;
impl Solution {
    pub fn min_interval(mut intervals: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        let mut queries: Vec<(usize, i32)> = queries
            .into_iter()
            .enumerate()
            .collect();
        
        queries.sort_unstable_by_key(|a| a.1);
        intervals.sort_unstable_by_key(|a| a[0usize]);

        let mut min_heap:BinaryHeap<Reverse<(i32, i32)>> = BinaryHeap::new();
        let mut i = 0usize;
        let mut result = vec![-1i32; queries.len()];

        for (index, query) in queries {
            // push to heap 
            while i < intervals.len() && intervals[i][0] <= query {
                let size = intervals[i][1] - intervals[i][0] + 1i32;
                min_heap.push(Reverse((size, intervals[i][1])));
                i += 1usize;
            }

            // pop from heap 
            while let Some(&Reverse((_, end))) = min_heap.peek() {
                if end < query {
                    min_heap.pop();
                } else {
                    break;
                }
            }

            // this is the result
            if let Some(&Reverse((size, _))) = min_heap.peek() {
                result[index] = size;
            }
        }
        result
    }
}
