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

    record Result(int rob, int skip){
        public int max() {
            return Math.max(this.rob, this.skip);
        }
    }

    public int rob(TreeNode root) {
        return dfs(root).max();
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(0, 0);
        }

        var left = dfs(node.left);
        var right = dfs(node.right);

        int rob = node.val + left.skip() + right.skip();
        int skip = left.max() + right.max();

        return new Result(rob, skip);
    }
}