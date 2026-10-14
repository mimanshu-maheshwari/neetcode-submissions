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
    private int count, result;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return result;
    }
    
    private void dfs(TreeNode node) {
        if (node == null || count == 0) return;
        dfs(node.left);
        if (--count == 0) result = node.val;
        dfs(node.right);
    }
}
