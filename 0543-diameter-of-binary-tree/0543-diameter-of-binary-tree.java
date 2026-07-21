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

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }

    public int height(TreeNode root){

        // Empty tree ki height
        if(root == null){
            return 0;
        }

        // Left subtree ki height
        int left = height(root.left);

        // Right subtree ki height
        int right = height(root.right);

        // Current node se diameter
        diameter = Math.max(diameter, left + right);

        // Height return karo
        return Math.max(left, right) + 1;
    }
}