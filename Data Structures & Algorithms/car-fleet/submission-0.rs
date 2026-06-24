struct Cell {
    position: i32, 
    speed: i32,
}
impl Cell {
    fn new(position: i32, speed: i32) -> Self {
        Self {
            position,
            speed,
        }
    }
}

impl Solution {
    pub fn car_fleet(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        let n = speed.len();
        let mut cells = Vec::new();
        for i in 0..n {
            cells.push(Cell::new(position[i], speed[i]));
        }
        cells.sort_unstable_by(|a, b| b.position.cmp(&a.position));
        let mut stack = Vec::new();
        for cell in cells {
            let time = (target - cell.position) as f64 / cell.speed as f64;
            if let Some(prev_time) = stack.last() {
                if *prev_time < time {
                    stack.push(time);
                }
            } else {
                stack.push(time);
            }
        }
        stack.len() as i32
    }
}

/*
 [4,1,0,7]   [2,2,1,1], 10, 0
 [0,1,4,7]   [1,2,2,1], 10, 0
 [1,3,6,8]   [1,2,2,1], 10, 0
 [2,5,8,9]   [1,2,2,1], 10, 0
 [3,7,10,10] [1,2,1,1], 10, 1
 [3,9,10,10] [1,2,1,1], 10, 1
 [3,11,10,10] [1,2,1,1], 10, 2
 [4,11,10,10] [1,2,1,1], 10, 2
 [5,11,10,10] [1,2,1,1], 10, 2
 [6,11,10,10] [1,2,1,1], 10, 2
 [7,11,10,10] [1,2,1,1], 10, 2
 [8,11,10,10] [1,2,1,1], 10, 2
 [9,11,10,10] [1,2,1,1], 10, 2
 [10,11,10,10] [1,2,1,1], 10, 3
*/
