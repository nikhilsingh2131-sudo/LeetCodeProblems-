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
    public boolean findTarget(TreeNode root, int k) {

        return check(root , root , k);
        
    }public boolean check(TreeNode root , TreeNode current , int k){
        if(current==null){
            return false;
        }

        int diff = k- current.val;

        if(search(root , diff , current)){
            return true;
        }
          return check(root, current.left, k) ||
               check(root, current.right, k);
    }public boolean search(TreeNode root , int target , TreeNode current){
        if(root==null) return false;

        if(root.val==target && root!=current){
            return true;
        }
         if (target < root.val) {
            return search(root.left, target, current);
        } else {
            return search(root.right, target, current);
        }

    }
}