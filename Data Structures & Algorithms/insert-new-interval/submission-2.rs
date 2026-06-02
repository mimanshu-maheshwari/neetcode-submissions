impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        let mut output : Vec<Vec<i32>> = Vec::new();
        let mut index = 0; 
        while index < intervals.len() && new_interval[0] > intervals[index][1] {
            if let Some(last_interval) = output.last_mut() 
                && last_interval[1] >= intervals[index][0] {
                last_interval[0] = last_interval[0].min(intervals[index][0]);
                last_interval[1] = last_interval[1].max(intervals[index][1]);
            } else {
                output.push(intervals[index].clone());
            }
            index += 1;
        }
        output.push(new_interval);
        for i in index..intervals.len() {
            if let Some(last_interval) = output.last_mut() && 
            last_interval[1] >= intervals[i][0] {
                last_interval[0] = last_interval[0].min(intervals[i][0]);
                last_interval[1] = last_interval[1].max(intervals[i][1]);
            } else {
                output.push(intervals[i].clone());
            }
        }
        output
    }
}
