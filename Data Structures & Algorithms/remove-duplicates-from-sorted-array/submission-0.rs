impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        let (mut left, mut right) = (0usize, 0usize);
        while right < nums.len() {
            if nums[left] == nums[right] {
                right += 1;
                continue;
            }
            if nums[left] != nums[right] {
                left += 1;
                nums.swap(left, right);
                right += 1;
            }
        }
        left as i32 + 1i32
    }
}
