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
    List<Integer> elem = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return elem.get(elem.size() - k);
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            dfs(node.right);
        }
        elem.add(node.val);
        if (node.left != null) {
            dfs(node.left);
        }
    }
}
