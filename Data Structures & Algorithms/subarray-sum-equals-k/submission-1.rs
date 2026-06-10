impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        let mut res = 0;
        let mut cur_sum = 0;
        let mut prefix_sums = HashMap::new();
        prefix_sums.insert(0, 1);

        for &num in &nums {
            cur_sum += num;
            let diff = cur_sum - k;
            res += prefix_sums.get(&diff).unwrap_or(&0);
            *prefix_sums.entry(cur_sum).or_insert(0) += 1;
        }

        res
    }
}