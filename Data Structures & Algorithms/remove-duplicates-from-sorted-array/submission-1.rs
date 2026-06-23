impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        let (mut left, mut right) = (0usize, 0usize);
        while right < nums.len() {
            match nums[left] == nums[right]  {
                true => {
                    right += 1;
                },
                false => {
                    left += 1;
                    nums.swap(left, right);
                    right += 1;
                },
            }
        }
        left as i32 + 1i32
    }
}
