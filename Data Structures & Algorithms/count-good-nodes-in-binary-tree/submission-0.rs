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
    pub fn good_nodes(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let root_val = {
            if let Some(c) = &root {
                c.borrow().val
            } else {
                return 0;
            }
        };
        Self::nodes(&root, root_val)
    }
    fn nodes(curr: &Option<Rc<RefCell<TreeNode>>>, mut curr_max: i32) -> i32 {
        match curr {
            None => return 0,
            Some(curr) => {
                let node = curr.borrow();
                let mut count = 0_i32;
                if node.val >= curr_max {
                    count += 1_i32;
                    curr_max = node.val;
                }
                count += Self::nodes(&node.left, curr_max);
                count += Self::nodes(&node.right, curr_max);
                count
            }
        }

    }
}
