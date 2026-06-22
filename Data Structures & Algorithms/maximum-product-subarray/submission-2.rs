impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let mut res = nums[0];
        let (mut cur_min, mut cur_max) = (1, 1);
        for &num in &nums {
            let tmp = cur_max * num;
            cur_max = (num * cur_max).max(num * cur_min).max(num);
            cur_min = tmp.min(num * cur_min).min(num);
            res = res.max(cur_max);
        }
        res
    }
}