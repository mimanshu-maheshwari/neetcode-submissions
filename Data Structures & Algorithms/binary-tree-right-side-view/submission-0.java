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
    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode lastNode = null;
            int size = queue.size();
            for (int i = 0; i < size; ++i){
                var curr = queue.poll();
                if (i == size - 1){
                    lastNode = curr;
                }
                if (curr.left!= null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
            if (lastNode != null) {
                result.add(lastNode.val);
            }

        }

        return result;
    }
}
