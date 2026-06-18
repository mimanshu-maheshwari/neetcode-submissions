impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        let n = heights.len();
        let mut max_area = 0;
        let mut stack: Vec<(usize, i32)> = Vec::new();
        for (index, &height) in heights.iter().enumerate() {
            let mut start = index;
            while let Some(&(i, h)) = stack.last() {
                if h > height {
                    stack.pop();
                    max_area = max_area.max((index - i) as i32 * h);
                    start = i;
                } else {
                    break;
                }
            }
            stack.push((start, height));
        }
        for (index, height) in stack {
            max_area = max_area.max(height * (n - index) as i32);
        }
        max_area
    }
}
