impl Solution {
    pub fn find_closest_elements(arr: Vec<i32>, k: i32, x: i32) -> Vec<i32> {
        let n = arr.len();
        let k = k as usize;
        let (mut left, mut right) = (0, n - k);

        while left < right {
            let mid = left + ((right - left) >> 1);
            if x - arr[mid] > arr[mid + k] - x {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        arr[left..left+k].to_vec()
    }
}
