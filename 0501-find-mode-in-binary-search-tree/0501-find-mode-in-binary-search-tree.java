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

    List<Integer> list = new ArrayList<>();
    int max = 0;
    int prev =Integer.MIN_VALUE;
    int count =0;

    public int[] findMode(TreeNode root) {

        dfs(root);
        int[]ans = new int[list.size()];

        for(int i =0 ; i<list.size() ; i++){
            ans[i] = list.get(i);
        }
        
        return ans ;

    }public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);

        if(root.val==prev){
            count ++;
        }else{
            count = 1;
        }

        if(count>max){
            list.clear();
            list.add(root.val);
            max = count;
        }else if(count == max){
            list.add(root.val);
        }

        prev = root.val;

        dfs(root.right);
    }
}