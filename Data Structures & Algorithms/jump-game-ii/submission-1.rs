impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        let (mut farthest, mut current_end, mut jumps) = (0i32, 0i32, 0i32);
        for i in 0..nums.len() - 1 {
            farthest = farthest.max(i as i32 + nums[i]);
            if current_end == i as i32 {
                jumps += 1;
                current_end = farthest;
            }
        }
        jumps
    }
}
