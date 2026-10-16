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
    record Key(TreeNode node, boolean canRob){}

    HashMap<Key, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        return dfs(root, true);
    }

    private int dfs(TreeNode node, boolean canRob) {
        if (node == null) {
            return 0;
        }
        Key key = new Key(node, canRob);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int result = 0;
        if (canRob) {
            // does rob
            int left = dfs(node.left, false);
            int right = dfs(node.right, false);
            result = Math.max(result, node.val + left + right);
        } else {
            int left = dfs(node.left, true);
            int right = dfs(node.right, true);
            result = Math.max(result, left + right);
        }

        // does nothing
        result = Math.max(result, dfs(node.left, canRob) + dfs(node.right, canRob));
        dp.put(key, result);
        return result;
    }
}