class Solution {

    public int distinctSubseqII(String s) {

        int MOD = 1000000007;
        int n = s.length();

        // dp[i] = first i characters ki distinct subsequences
        // empty subsequence included
        long[] dp = new long[n + 1];

        dp[0] = 1;

        int[] last = new int[26];

        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }

        for (int i = 1; i <= n; i++) {

            int ch = s.charAt(i - 1) - 'a';

            // Har old subsequence ke 2 options:
            // 1. current character nahi lo
            // 2. current character lo
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Duplicate remove
            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch] - 1] + MOD) % MOD;
            }

            // Current character ki latest position
            last[ch] = i;
        }

        // Empty subsequence remove
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}