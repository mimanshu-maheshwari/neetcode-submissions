impl Solution {
    pub fn first_missing_positive(mut nums: Vec<i32>) -> i32 {
        let mut i = 0;
        let n = nums.len();
        while i < n {
            if nums[i] <= 0 || nums[i] > n as i32 {
                i += 1;
                continue;
            }
            let val = nums[i].abs() as usize - 1;
            if nums[i] != nums[val] {
                nums.swap(i, val);
            }  else {
                i += 1;
            }
        }
        for i in 0..n {
            if nums[i] != (i + 1) as i32 {
                return (i + 1) as i32;
            }
        }
        return n as i32 + 1;
    }
}
