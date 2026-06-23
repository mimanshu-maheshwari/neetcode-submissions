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
    pub fn inorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        fn dfs(root: &Option<Rc<RefCell<TreeNode>>>, result: &mut Vec<i32>) {
            let Some(node) = root else { return; };
            let node = node.borrow();
            dfs(&node.left, result);
            result.push(node.val);
            dfs(&node.right, result);
        }
        let mut result = Vec::new();
        dfs(&root, &mut result);
        result
    }
}
