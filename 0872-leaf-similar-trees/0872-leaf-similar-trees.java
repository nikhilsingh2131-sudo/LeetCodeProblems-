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

    private void inorder(TreeNode  root ,List<Integer>level ){
        if(root == null){
            return;
        }

        if(root.left==null && root.right==null){
            level.add(root.val);
        }

        inorder(root.left , level);
        inorder(root.right , level);

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> level1 = new ArrayList<>();
        List<Integer> level2 = new ArrayList<>();

        inorder(root1 , level1);
        inorder(root2 , level2);

        return level1.equals(level2);


        
    }
}