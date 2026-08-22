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
    public int maxLevelSum(TreeNode root) {

        int ans =0;
        if(root==null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int max = Integer.MIN_VALUE;
        int level=0;

        while(!q.isEmpty()){
            int size = q.size();
            int sum =0;
            level++;

            for(int i=0 ; i<size ; i++){
               TreeNode curr = q.poll();
               sum += curr.val;

               if(curr.left!=null){
                q.offer(curr.left);
               }

               if(curr.right!=null){
                q.offer(curr.right);
               }
            }

            if(sum>max){
                ans = level;
                max = sum;
            }
            
        }
        return ans;
    }
}