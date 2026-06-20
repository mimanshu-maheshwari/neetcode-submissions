impl Solution {
    pub fn max_area(heights: Vec<i32>) -> i32 {
        let mut max_water = 0;
        let len = heights.len();
        let (mut l, mut r) = (0usize, len - 1);
        while l < r {
            max_water = max_water.max((r - l) as i32 * heights[l].min(heights[r]));
            if heights[l] <= heights[r] {
                l += 1;
            } else {
                r -= 1;
            }
        }
        max_water
    }
}
