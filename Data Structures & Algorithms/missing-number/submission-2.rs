impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut xor = n as i32;
        for (i, num) in nums.iter().enumerate() {
            xor ^= (i as i32) ^ num;
        }
        xor
    }
}
