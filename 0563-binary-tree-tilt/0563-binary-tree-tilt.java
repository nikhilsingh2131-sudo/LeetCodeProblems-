class Solution {

    int ans = 0;

    public int findTilt(TreeNode root) {
        getSum(root);
        return ans;
    }

    public int getSum(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = getSum(root.left);
        int right = getSum(root.right);

        ans += Math.abs(left - right);

        return left + right + root.val;
    }
}