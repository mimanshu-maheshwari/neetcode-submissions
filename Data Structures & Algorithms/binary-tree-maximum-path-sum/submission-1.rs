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
    pub fn max_path_sum(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut res = i32::MIN;
        Self::dfs(&root, &mut res);
        res
    }

    fn dfs(root: &Option<Rc<RefCell<TreeNode>>>, max: &mut i32) -> i32 {
        if let Some(node) = root {
            let node = node.borrow();
            let left = Self::dfs(&node.left, max).max(0);
            let right = Self::dfs(&node.right, max).max(0);
            *max = (*max).max(node.val + left + right);
            node.val + left.max(right)
        } else {
            0
        }
    }
}
