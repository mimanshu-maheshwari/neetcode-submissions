impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut result = vec![vec![]];
        for &num in nums.iter() {
            let new: Vec<Vec<i32>> = result.iter()
                .map(|s| {let mut s = s.clone(); s.push(num); s})
                .collect();
            result.extend(new);
        }
        result
    }
}
