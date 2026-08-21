class Solution {

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        return countPaths(root, 0L, (long) targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int countPaths(TreeNode root, long sum, long target) {

        if (root == null) {
            return 0;
        }

        sum += root.val;

        int count = 0;

        if (sum == target) {
            count++;
        }

        count += countPaths(root.left, sum, target);
        count += countPaths(root.right, sum, target);

        return count;
    }
}