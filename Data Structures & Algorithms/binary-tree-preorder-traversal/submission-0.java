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
    public List<Integer> preorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        dfs(root, result);
        return result;
    }
    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.left != null) {
            dfs(node.left, result);
        }
        if (node.right != null) {
            dfs(node.right, result);
        }
    }
}