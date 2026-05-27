use std::{collections::BinaryHeap, cmp::Reverse};

impl Solution {
    pub fn most_booked(n: i32, mut meetings: Vec<Vec<i32>>) -> i32 {
        meetings.sort_unstable_by_key(|a| a[0]);

        let mut room_counts = vec![0; n as usize];

        // rooms
        let mut available= BinaryHeap::new();
        for i in 0..n {
            available.push(Reverse(i));
        }

        // end time , room
        let mut used: BinaryHeap<Reverse<(i64, i32)>> = BinaryHeap::new();
        for meeting in meetings {
            let start = meeting[0] as i64;
            let mut end = meeting[1] as i64;

            while let Some(&Reverse((end_time, _))) = used.peek() {
                if start > end_time {
                    let Reverse((_, room)) = used.pop().unwrap();
                    available.push(Reverse(room));
                } else {
                    break;
                }
            }
            if available.is_empty() {
                let Reverse((end_time, room)) = used.pop().unwrap();
                end = end_time + (end - start);
                available.push(Reverse(room));
            }
            let Reverse(room) = available.pop().unwrap();
            used.push(Reverse((end, room)));
            room_counts[room as usize] += 1;

        }
        let mut max_meetings = 0;
        for (i, &count) in room_counts.iter().enumerate() {
            println!("{i} : {count}");
            if count > room_counts[max_meetings] {
                max_meetings = i;
            }
        }
        max_meetings as i32
    }
}
