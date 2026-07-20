impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let n = nums.len();
        let (mut l, mut r) = (0, n - 1);
        while l <= r {
            let m = l + ((r - l) >> 1);
            if nums[m] == target {
                return m as i32;
            } else if nums[m] < target {
                l = m + 1; 
            } else {
                if m == 0 {
                    break;
                }
                r = m - 1;
            }
        }
        -1
    }
}
 