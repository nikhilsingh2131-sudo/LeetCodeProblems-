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

    public TreeNode deleteNode(TreeNode root, int key) {

        // Node nahi mila
        if (root == null) {
            return null;
        }

        // Key chhoti hai → left
        if (key < root.val) {

            root.left = deleteNode(root.left, key);

        }

        // Key badi hai → right
        else if (key > root.val) {

            root.right = deleteNode(root.right, key);

        }

        // Key mil gayi
        else {

            // Case 1 + Case 2
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children

            // Right subtree ka minimum
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            // Value replace
            root.val = successor.val;

            // Duplicate successor ko delete
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}