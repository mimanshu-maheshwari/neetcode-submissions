impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        let mut data = Vec::new();
        for op in operations {
            let op = op.as_str();
            match op {
                "+" => {
                    data.push(data[data.len() - 1] + data[data.len() - 2]);
                },
                "D" => {
                    data.push(data[data.len() - 1] * 2);
                },
                "C" => {
                    data.pop();
                },
                num_str => {
                    data.push(num_str.parse::<i32>().expect("Invalid number!!"));
                }
            }
        }
        data.into_iter().sum()
    }
}
