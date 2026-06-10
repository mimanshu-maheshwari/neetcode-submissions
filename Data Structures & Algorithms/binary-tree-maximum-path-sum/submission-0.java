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
    public int maxPathSum(TreeNode root) {
        if (root ==  null){
            return 0;
        }
        int[] max = new int[]{root.val};
        dfs(root, max);
        return max[0];
    }
    // dfs 
    // track max value till now
    // return curr path sum
    private int dfs(TreeNode node, int[] maxValue) {
        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(node.left, maxValue));
        int rightMax = Math.max(0, dfs(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], leftMax + node.val + rightMax);
        return node.val + Math.max(leftMax, rightMax);
    }
}
