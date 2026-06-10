impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        let mut prefix = vec![0; nums.len()];
        prefix[0] = nums[0];
        for i in 1..nums.len() {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        // prefix sum, index count
        let mut map = HashMap::new();
        let mut count = 0;
        for (i, &num) in nums.iter().enumerate() {
            // if num == k {
            //     count += 1;
            // }
            if prefix[i] == k {
                count += 1;
            }
            let dif = prefix[i] - k;
            if map.contains_key(&dif){ 
                count += map[&dif];
            }
            map.entry(prefix[i]).and_modify(|v| *v += 1).or_insert(1);
        }
        count
    }
}
