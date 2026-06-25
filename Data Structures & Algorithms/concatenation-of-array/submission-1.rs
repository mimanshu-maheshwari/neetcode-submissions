impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
        let mut result = vec![0; nums.len() * 2];
        for (i, &val) in nums.iter().enumerate() {
            result[i] = val;
            result[i + nums.len()] = val;
        }
        result
    }
}
