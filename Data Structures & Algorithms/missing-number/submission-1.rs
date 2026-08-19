impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut xor = nums[0] ^ 0i32;
        for (i, num) in nums.iter().enumerate().skip(1) {
            xor ^= (i as i32) ^ num;
        }
        xor ^= n as i32;
        xor
    }
}
