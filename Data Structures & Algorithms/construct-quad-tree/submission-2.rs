// Definition for a QuadTree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct Node {
//     pub val: bool,
//     pub is_leaf: bool,
//     pub top_left: Option<Rc<RefCell<Node>>>,
//     pub top_right: Option<Rc<RefCell<Node>>>,
//     pub bottom_left: Option<Rc<RefCell<Node>>>,
//     pub bottom_right: Option<Rc<RefCell<Node>>>,
// }
//
// impl Node {
//     #[inline]
//     pub fn new(val: bool, is_leaf: bool) -> Self {
//         Node {
//             val,
//             is_leaf,
//             top_left: None,
//             top_right: None,
//             bottom_left: None,
//             bottom_right: None,
//         }
//     }
// }

use std::rc::Rc;
use std::cell::RefCell;

impl Solution {
    pub fn construct(grid: Vec<Vec<i32>>) -> Option<Rc<RefCell<Node>>> {
        let n = grid.len() as i32;
        Self::dfs(&grid, 0, 0, n - 1, n - 1)
    }

    fn dfs(
        grid: &Vec<Vec<i32>>,
        r1: i32, c1: i32,
        r2: i32, c2: i32,
    ) -> Option<Rc<RefCell<Node>>> {
        if r1 > r2 || c1 > c2 { return None; }

        // check if all same value
        let val = grid[r1 as usize][c1 as usize];
        let all_same = (r1..=r2).flat_map(|r| (c1..=c2).map(move |c| (r, c)))
            .all(|(r, c)| grid[r as usize][c as usize] == val);

        if all_same {
            return Some(Rc::new(RefCell::new(Node::new(val == 1, true))));
        }

        let mid_r = (r1 + r2) / 2;
        let mid_c = (c1 + c2) / 2;

        let mut node = Node::new(true, false);
        node.top_left     = Self::dfs(grid, r1,       c1,       mid_r,   mid_c);
        node.top_right    = Self::dfs(grid, r1,       mid_c+1,  mid_r,   c2);
        node.bottom_left  = Self::dfs(grid, mid_r+1,  c1,       r2,      mid_c);
        node.bottom_right = Self::dfs(grid, mid_r+1,  mid_c+1,  r2,      c2);

        Some(Rc::new(RefCell::new(node)))
    }
}
