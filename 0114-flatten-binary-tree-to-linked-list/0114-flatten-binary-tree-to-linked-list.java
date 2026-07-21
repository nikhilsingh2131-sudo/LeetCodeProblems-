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

    TreeNode prev = null; // Previous processed node

    public void flatten(TreeNode root) {

        // Agar node null hai to kuch nahi karna
        if (root == null)
            return;

        // Pehle RIGHT subtree flatten karo
        flatten(root.right);

        // Fir LEFT subtree flatten karo
        flatten(root.left);

        // Current node ka right previous node ban jayega
        root.right = prev;

        // Left hamesha null karna hai
        root.left = null;

        // Ab current node hi previous ban jayega
        prev = root;
    }
}