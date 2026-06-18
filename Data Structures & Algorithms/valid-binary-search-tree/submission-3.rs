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

type Node = Rc<RefCell<TreeNode>>;

impl Solution {
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        fn validate(root: &Option<Node>, low: Option<i32>, high: Option<i32>) -> bool {
            if let Some(node) = root {
                let node = node.borrow();
                let val = node.val;
                if low.is_some_and(|l| val <= l) { return false; }
                if high.is_some_and(|r| val >= r) { return false; }
                return validate(&node.left, low, Some(val)) && validate(&node.right, Some(val), high);
            }
            true
        }
        return validate(&root, None, None);
    }
}













