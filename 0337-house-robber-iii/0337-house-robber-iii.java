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

    public int rob(TreeNode root) {

        // dfs(root) root ke liye 2 values return karega
        // ans[0] = agar root ko lootte NAHI hain
        // ans[1] = agar root ko lootte HAIN
        int[] ans = dfs(root);

        // Dono me se maximum answer return kar do
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {

        // Agar node hi nahi hai
        // Na loot sakte hain, na paisa milega
        if (root == null)
            return new int[]{0, 0};

        // Pehle left subtree ka answer nikal lo
        int[] left = dfs(root.left);

        // Fir right subtree ka answer nikal lo
        int[] right = dfs(root.right);

        /*
            left[0] = left child ko lootte NAHI hain
            left[1] = left child ko lootte HAIN

            right[0] = right child ko lootte NAHI hain
            right[1] = right child ko lootte HAIN
        */

        // ------------------- CASE 1 -------------------
        // Agar current node ko loot liya
        //
        // To direct children ko loot NAHI sakte
        //
        // Isliye left[0] aur right[0] use karenge
        int rob = root.val + left[0] + right[0];

        // ------------------- CASE 2 -------------------
        // Agar current node ko lootte hi nahi
        //
        // To left child ko loot bhi sakte hain
        // Ya nahi bhi loot sakte
        //
        // Jo zyada paisa de usko choose karenge
        int notRob =
                Math.max(left[0], left[1])
              + Math.max(right[0], right[1]);

        // Current node ke liye dono possibilities return kar do
        //
        // index 0 -> current node NOT robbed
        // index 1 -> current node robbed
        return new int[]{notRob, rob};
    }
}