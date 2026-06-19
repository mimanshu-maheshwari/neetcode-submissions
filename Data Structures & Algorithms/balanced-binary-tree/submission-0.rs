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
        let height = Self::get_height(&root);
        if height == -1i32 {
            false
        } else {
            true
        }
    }

    fn get_height(root: &Option<Rc<RefCell<TreeNode>>>) -> i32 {
        match root { 
            None => 0,
            Some(node) => {
                let node = node.borrow(); 
                let right_node = &node.right;
                let left_node = &node.left;
                let right_height = Self::get_height(&right_node);
                if right_height == -1 {
                    return -1;
                }
                let left_height = Self::get_height(&left_node);
                if left_height == -1 {
                    return -1;
                }
                if (right_height - left_height).abs() > 1 {
                    return -1;
                }
                1 + right_height.max(left_height)
            }
        }
    }
}
