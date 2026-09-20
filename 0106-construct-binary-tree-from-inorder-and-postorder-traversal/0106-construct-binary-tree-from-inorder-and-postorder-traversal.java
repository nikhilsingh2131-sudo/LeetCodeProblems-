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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length ;

        return build(inorder , postorder , 0 , n-1 , 0 , n-1);

        
    }public TreeNode build(int[] inorder, int[] postorder , int inStart ,int  inEnd , int postStart , int postEnd){
        if(inStart > inEnd){
            return null;
        }
        
        // postorder last element is always root of tree 
        int rootVal = postorder[postEnd];

        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inStart;
        for(; rootIndex<=inEnd ;rootIndex++){
            if(rootVal == inorder[rootIndex]){
                break;
            }
        }

        int leftTreeSize = rootIndex- inStart;
        int rightTreeSize = inEnd- rootIndex;

        root.left = build(inorder , postorder , inStart , rootIndex-1 ,postStart ,postStart +leftTreeSize - 1);
        root.right = build(inorder ,postorder , rootIndex+1 , inEnd , postEnd - rightTreeSize , postEnd-1);

        return root ;
    }
}