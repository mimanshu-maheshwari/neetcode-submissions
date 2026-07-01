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

type NodePtr = Rc<RefCell<Node>>;

impl Solution {
    pub fn construct(grid: Vec<Vec<i32>>) -> Option<Rc<RefCell<Node>>> {
        let n = grid.len() as i32;
        Self::dfs(&grid, (0, 0), (n - 1, n - 1))
    }

    /// divide the grid into four sectons
    /// mid_row = (from_row + to_row) >> 1
    /// mid_col = (from_col + to_col) >> 1
    /// check for (0..mid_row)(0..mid_col)
    /// check for (0..mid_row)(mid_col..=to_col)
    /// check for (mid_row..=to_row)(0..mid_col)
    /// check for (mid_row..=to_row)(mid_col..=to_col)
    /// start and end are (row, col) pair
    fn dfs(
        grid: &Vec<Vec<i32>>, 
        start: (i32, i32), 
        end: (i32, i32)
    ) -> Option<NodePtr> {
        if start.0 < 0 
        || start.1 < 0 
        || end.0 >= grid.len() as i32 
        || end.1 >= grid.len() as i32 {
            return None;
        }
        if start.0 == end.0 && start.1 == end.1 {
            let val = grid[start.0 as usize][start.1 as usize] == 1; 
            let node = Rc::new(RefCell::new(Node::new(val, true)));
            return Some(node);
        }
        if let Some(same) = Self::all_same(grid, start.0 as usize, end.0 as usize, start.1 as usize, end.1 as usize) {
            let node = Rc::new(RefCell::new(Node::new(same, true)));
            return Some(node);
        }

        let mut node = Node::new(true, false);

        let mid_row = (start.0 + end.0 + 1) >> 1;
        let mid_col = (start.1 + end.1 + 1) >> 1;

        if mid_row < 0 
        || mid_col < 0 
        || mid_row >= grid.len() as i32
        || mid_col >= grid.len() as i32 {
            return None;
        }

        node.top_left     = Self::dfs(grid, (start.0, start.1), (mid_row - 1, mid_col - 1));
        node.top_right    = Self::dfs(grid, (start.0, mid_col), (mid_row - 1, end.1));
        node.bottom_left  = Self::dfs(grid, (mid_row, start.1), (end.0      , mid_col - 1));
        node.bottom_right = Self::dfs(grid, (mid_row, mid_col), (end.0      , end.1));

        Some(Rc::new(RefCell::new(node)))
    }

    /// if this is a leaf node then 
    ///     return true if all 1 else 0
    /// else return none
    fn all_same(
        grid: &Vec<Vec<i32>>, 
        from_row: usize, 
        to_row: usize, 
        from_col:usize, 
        to_col: usize
    ) -> Option<bool> {
        let start_value = grid[from_row][from_col];
        for row in from_row..=to_row {
            for col in from_col..=to_col {
                if start_value != grid[row][col] {
                    return None;
                }
            }
        }
        if start_value == 1 {
            Some(true)
        } else {
            Some(false)
        }
    }
}
