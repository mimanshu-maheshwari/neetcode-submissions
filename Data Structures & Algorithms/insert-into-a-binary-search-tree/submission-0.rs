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
    pub fn insert_into_bst(root: Option<Rc<RefCell<TreeNode>>>, val: i32) -> Option<Rc<RefCell<TreeNode>>> {
        Self::insert(&root, val)
    }
    fn insert(root: &Option<Rc<RefCell<TreeNode>>>, val: i32) -> Option<Rc<RefCell<TreeNode>>> {
        let Some(node) = root else {
            return Some(Rc::new(RefCell::new(TreeNode::new(val))));
        };
        if val < node.borrow().val {
            let left = &node.borrow().left.clone();
            node.borrow_mut().left = Self::insert(left, val);
        } else {
            let right = &node.borrow().right.clone();
            node.borrow_mut().right = Self::insert(right, val);
        }
        Some(Rc::clone(node))
    }
}
