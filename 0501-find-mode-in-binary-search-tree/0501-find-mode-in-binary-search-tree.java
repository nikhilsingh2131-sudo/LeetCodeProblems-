class Solution {
    public int[] findMode(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<>();

        if(root == null){
            return new int[0];
        }

        find(root, map);

        int max = 0;

        for(int freq : map.values()){
            max = Math.max(max, freq);
        }

        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }

        int[] ans = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    public void find(TreeNode root, Map<Integer, Integer> map){

        if(root == null){
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        find(root.left, map);
        find(root.right, map);
    }
}