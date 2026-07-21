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
    int level1 = 0;
    int level2 = 1;
    TreeNode p1 = null;
    TreeNode p2 = null;
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;

        dfs(root, 0, null);

        return level1 == level2 && p1 != p2;
    }

    public void dfs(TreeNode root, int level, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            level1 = level;
            p1 = parent;
        }

        if (root.val == y) {
            level2 = level;
            p2 = parent;
        }

        dfs(root.left, level + 1, root);
        dfs(root.right, level + 1, root);
    }
}