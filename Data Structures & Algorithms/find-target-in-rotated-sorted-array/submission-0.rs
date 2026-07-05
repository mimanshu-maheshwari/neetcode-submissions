impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let len = nums.len() as i32;
        let (mut left, mut right) = (0i32, len - 1i32);
        while left <= right {
            let mid = left + ((right - left) >> 1);
            if nums[mid as usize] == target {
                return mid;
            }
            // sorted half
            if nums[left as usize] <= nums[mid as usize] {
                if target > nums[mid as usize] || target < nums[left as usize] {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // reversed half
            else {
                if target < nums[mid as usize] || target > nums[right as usize] {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        -1i32
    }
}


/* 
if mid < target 
   mid < right // sorted half
    left = mid + 1;
   mid > right // decresing half
    right = mid - 1;

if target < mid

*/
