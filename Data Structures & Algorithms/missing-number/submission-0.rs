impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut xor = 0 as i32;
        for i in 1..=n {
            xor ^= i as i32;
        }
        for num in nums {
            xor ^= num as i32;
        }
        xor
    }
}
