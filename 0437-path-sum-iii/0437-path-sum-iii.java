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
    public int pathSum(TreeNode root, int targetSum) {

        if(root==null){
            return 0;
        }

        return Pathcount(root , 0L  , targetSum)
               +pathSum(root.left , targetSum)
               +pathSum(root.right , targetSum);
        
    }
    public int Pathcount(TreeNode root , Long sum  , int target){
        if(root==null){
            return 0;
        }

        int count =0;

        sum+=root.val;

        if(sum==target){
            count++;
        }

       count += Pathcount(root.left ,sum , target);
       count += Pathcount(root.right , sum , target);

        return count ;
    }
}