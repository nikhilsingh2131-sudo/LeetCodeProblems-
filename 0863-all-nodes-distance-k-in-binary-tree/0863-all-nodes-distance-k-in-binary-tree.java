/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { 
     Map<TreeNode, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        makeparents(root);

        Queue<TreeNode> q= new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance =0;

        while(!q.isEmpty()){
            if(distance == k){
                List<Integer> ans = new ArrayList<>();

                while(!q.isEmpty()){
                    ans.add(q.poll().val);
                }

                return ans ;
            }

            int size = q.size();

            for(int i =0 ; i< size ; i++){
               TreeNode node = q.poll();

               if(node.left!=null && !visited.contains(node.left)){
                q.offer(node.left);
                visited.add(node.left);
               }

               if(node.right!=null && !visited.contains(node.right)){
                q.offer(node.right);
                visited.add(node.right);
               }

                TreeNode p = parent.get(node);
            if(p!=null && !visited.contains(p)){
                visited.add(p);
                    q.add(p);

            }
            }

           

            distance++;

        }

        return new ArrayList<>();

        
    } void makeparents(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node =q.poll();

            if(node.left!=null){
                parent.put(node.left , node);
                q.offer(node.left);
            }

               if (node.right != null) {

                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}