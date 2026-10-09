
class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>());
        return ans;
    }

    public void backtrack(int start, int[] candidates, int target, List<Integer> temp) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (start == candidates.length) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target) {
                continue;
            }

            temp.add(candidates[i]);

            backtrack(i, candidates, target - candidates[i], temp);

            temp.remove(temp.size() - 1);
        }
    }
}