use std::collections::HashMap;

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut count_map: HashMap<i32, i32> = HashMap::new();
        for n in &nums {
            *count_map.entry(*n).or_insert(0) += 1;
        }
        //println!("{:#?}", count_map);
        
        // Create an array of fixed size nums.len() + 1
        let mut buckets: Vec<Vec<i32>> = vec![Vec::new(); nums.len()+1];

        // Walk through our hashmap and create a vector of numbers at the index where the index is the frequency
        for (num, freq) in &count_map {
            buckets[*freq as usize].push(*num);
        }

        // Iterate from the highest -> lowest index in buckets vector
        // also instantiate a vector of size k
        let mut result: Vec<i32> = Vec::new();
        for i in (0..=nums.len()).rev(){
            if result.len() >= k as usize {
                return result;
            }
            for num in &buckets[i] {
                result.push(*num);
            }
        }
        return result;
    }
}
