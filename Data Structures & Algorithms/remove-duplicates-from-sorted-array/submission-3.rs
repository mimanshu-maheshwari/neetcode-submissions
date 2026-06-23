impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        let mut left = 0;
        for right in 1..nums.len() {
            if nums[right] != nums[left] {
                left += 1;
                nums[left] = nums[right];
            }
        }
        left as i32 + 1
    }
}
