class Solution {
    public int arrangeCoins(int n) {
        int count = n;

        for (int i = 1; i <= n; i++) {
            if (count < i) {
                return i - 1;
            }
            count -= i;
        }

        return n;
    }
}