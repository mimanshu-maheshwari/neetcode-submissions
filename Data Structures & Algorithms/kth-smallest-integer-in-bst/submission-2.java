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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elem = new ArrayList<>();
        dfs(root, elem);
        return elem.get(k - 1);
    }
    private void dfs(TreeNode node, List<Integer> elem) {
        if (node == null) return;
        dfs(node.left, elem);
        elem.add(node.val);
        dfs(node.right, elem);
    }
}
