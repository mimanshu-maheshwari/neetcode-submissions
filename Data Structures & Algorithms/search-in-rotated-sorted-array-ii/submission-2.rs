impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> bool {
        let len = nums.len();
        let (mut left, mut right) = (0_i32, len as i32 - 1_i32);
        while left <= right {
            let mid = left + ((right - left) >> 1);
            // it is sorted
            if nums[mid as usize] == target {
                return true;
            }
            if nums[left as usize] < nums[mid as usize] {
                if nums[left as usize] <= target && target < nums[mid as usize] {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }  else if nums[left as usize] > nums[mid as usize] {
                if nums[mid as usize] < target && target <= nums[right as usize] {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left += 1;
            }
        }
        false
    }
}
