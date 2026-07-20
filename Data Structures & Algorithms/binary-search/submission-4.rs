impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let n = nums.len();
        let (mut l, mut r) = (0, n);

        while l < r {
            let m = l + ((r - l) >> 1);
            if nums[m] == target {
                return m as i32;
            } else if nums[m] < target {
                l = m + 1; 
            } else {
                r = m;
            }
        }
        if l > 0 && nums[l - 1] == target {
            (l - 1) as i32
        } else {
            -1
        }
    }
}
 