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
    class pair{
        TreeNode node;
        long index;

        pair(TreeNode node , long index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root , 0));

        int ans =0;

        while(!q.isEmpty()){

            int size = q.size();

            long first = q.peek().index;
            long last = first ;

            for(int i =0 ; i< size ; i++){
                pair curr = q.poll();

                long index = curr.index;
                last = index;

                if(curr.node.left!=null ){
                    q.add(new pair(
                        curr.node.left , 2*index+1
                    ));
                }

                if(curr.node.right!=null ){
                    q.add(new pair(
                        curr.node.right , 2*index+2
                    ));
                }
            }

            ans = Math.max(ans , (int)(last-first+1));


        }
        return ans ;
    }
}