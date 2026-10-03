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
    int sum =0;
    boolean result = false ;

    public void helper(TreeNode node  , int targetSum , int sum){
        if(node == null){
            return ;
        }

        sum = sum+ node.val;

        if(node.left==null && node.right== null){
            if(targetSum == sum){
                result = true;
            }else{
                return ;
            }
        }

        helper(node.left , targetSum , sum);
        helper(node.right , targetSum , sum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {

       if(root==null){
        return result ;
       }

       helper(root , targetSum  ,0);

       return result ;
        
    }
}