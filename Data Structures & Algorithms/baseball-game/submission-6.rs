impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        let mut data:Vec<i32> = Vec::new();
        for op in &operations {
            match op.as_str() {
                "+" => data.push(data[data.len() - 1] + data[data.len() - 2]),
                "D" => data.push(data[data.len() - 1] * 2),
                "C" => {data.pop(); },
                n   => data.push(n.parse().expect("Invalid number!!")),
            }
        }
        data.into_iter().sum()
    }
}
