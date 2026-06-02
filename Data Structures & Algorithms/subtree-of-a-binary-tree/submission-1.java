/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val && validateSubTree(root, subRoot)) {
            return true;
        }
        if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }
    private boolean validateSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return validateSubTree(root.right, subRoot.right) 
            && validateSubTree(root.left, subRoot.left);
        } 
        return false;
    }
}
