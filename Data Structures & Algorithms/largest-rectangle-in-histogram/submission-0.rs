impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        let mut max_area = 0i32;
        for (i, &height) in heights.iter().enumerate() {
            let (mut left, mut right) = (i, i);
            while left > 0 {
                if heights[left - 1] >= height {
                    left -= 1;
                } else {
                    break;
                }
            }
            while right + 1 < heights.len() {
                if heights[right + 1] >= height {
                    right += 1;
                } else {
                    break;
                }
            }
            println!("{left} : {i} : {right}");
            max_area = max_area.max((right - left + 1) as i32 * height);
        }
        max_area
    }
}
// brute force will be 
// for each candle find the max right and left we can go. 
// then (right - left + 1) * height[i]
