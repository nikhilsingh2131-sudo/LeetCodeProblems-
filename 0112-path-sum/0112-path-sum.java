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
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {

        dfs(root , 0,targetSum);
        return ans ;
        
    }public void dfs(TreeNode root , int sum , int target){
        if(root==null){
            return ;
        }

        sum +=  root.val;

        if (root.left == null && root.right == null) {
            if (sum == target) {
                ans = true;
            }
            return;
        }

        dfs(root.left , sum , target) ;
        dfs(root.right , sum , target);
    }
}