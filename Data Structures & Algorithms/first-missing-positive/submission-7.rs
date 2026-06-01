impl Solution {
    pub fn first_missing_positive(mut nums: Vec<i32>) -> i32 {
        let n = nums.len() as i32;

        for i in 0..nums.len() {
            if nums[i] < 0 {
                nums[i] = 0;
            }
        }

        for i in 0..nums.len() {
            let val = nums[i].abs();
            if val >= 1 && val <= n {
                let idx = val as usize - 1;
                if nums[idx] > 0 {
                    nums[idx] *= -1;
                } else if nums[idx] == 0 {
                    nums[idx] = -(n + 1);
                }
            }
        }

        for i in 0..nums.len() {
            if nums[i] >= 0 {
                return (i + 1) as i32;
            }
        }

        n + 1
    }
}