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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    private int dfs(TreeNode root) {

        // Base Case
        if (root == null) {
            return 0;
        }

        // Left aur Right subtree ka maximum gain
        int leftGain = Math.max(0, dfs(root.left));
        int rightGain = Math.max(0, dfs(root.right));

        // Current node se complete path
        int currentPath = root.val + leftGain + rightGain;

        // Global maximum update
        maxSum = Math.max(maxSum, currentPath);

        // Parent ko sirf ek side ka path return karna hai
        return root.val + Math.max(leftGain, rightGain);
    }
}