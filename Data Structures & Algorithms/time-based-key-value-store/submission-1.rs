use std::collections::HashMap;

struct TimeMap {
    map: HashMap<String, Vec<(i32, String)>>,
}

impl TimeMap {
    fn new() -> Self {
        Self {
            map: Default::default(),
        }
    }

    fn set(&mut self, key: String, value: String, timestamp: i32) {
        self.map
            .entry(key)
            .and_modify(|list| list.push((timestamp, value.clone())))
            .or_insert(vec![(timestamp, value)]);
    }

    fn get(&self, key: String, timestamp: i32) -> String {
        match self.map.get(&key) {
            None => String::new(),
            Some(list) => {
                // let index = Self::binary_search(&list, timestamp);
                // if index >= 0 && index < list.len() as i32 && list[index as usize].0 <= timestamp {
                //     list[index as usize].1.to_owned()
                // } else {
                //     String::new()
                // }
                match list.binary_search_by(|item| item.0.cmp(&timestamp)) {
                    Ok(index) => list[index].1.to_owned(),
                    Err(0) => String::new(),
                    Err(index) => list[index - 1].1.to_owned(),
                }
            },
        }
    }
    fn binary_search(list: &Vec<(i32, String)>, target: i32) -> i32 {
        let n = list.len() as i32;
        let (mut l, mut r) = (0i32, n - 1);
        while l <= r {
            let m = l + ((r - l) >> 1);
            if list[m as usize].0 == target {
                return m;
            } else if list[m as usize].0 < target {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        l - 1
    }
}
