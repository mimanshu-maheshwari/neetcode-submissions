impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let mut max_product = 1;
        let mut min_product = 1;
        let mut res = nums[0];
        for num in nums {
            let tmp = max_product * num;
            max_product = (num * max_product).max(num * min_product).max(num);
            min_product = tmp.min(num * min_product).min(num);
            res = res.max(max_product);
        }
        res
    }
}
