impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        fn can_split(largest: i32, nums: &[i32], k: i32) -> bool {
            let mut curr_sum = 0;
            let mut groups = 1;
            for &i in nums.iter() {
                curr_sum += i;
                if curr_sum > largest {
                    groups += 1;
                    if groups > k {
                        return false;
                    }
                    curr_sum = i;
                }
            }
            true
        }
        let (mut l, mut r) = (*nums.iter().max().unwrap(), nums.iter().sum::<i32>());
        let mut result = r;
        while l <= r {
            let m = l + ((r - l) >> 1);
            if can_split(m, &nums, k) {
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        result
    }
}
