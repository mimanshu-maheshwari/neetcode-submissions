// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//     pub val: i32,
//     pub left: Option<Rc<RefCell<TreeNode>>>,
//     pub right: Option<Rc<RefCell<TreeNode>>>,
// }
//
// impl TreeNode {
//     #[inline]
//     pub fn new(val: i32) -> Self {
//         TreeNode {
//             val,
//             left: None,
//             right: None,
//         }
//     }
// }

use std::rc::Rc;
use std::cell::RefCell;

impl Solution {
    pub fn is_balanced(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        Self::get_height(&root).is_some()

    }

    fn get_height(root: &Option<Rc<RefCell<TreeNode>>>) -> Option<i32> {
        match root { 
            None => Some(0),
            Some(node) => {
                let node = node.borrow(); 
                let right_node = &node.right;
                let left_node = &node.left;
                let Some(right_height) = Self::get_height(&right_node) else {return None;};
                let Some(left_height) = Self::get_height(&left_node) else {return None;};
                if (right_height - left_height).abs() > 1 {
                    return None;
                }
                Some(1 + right_height.max(left_height))
            }
        }
    }
}
