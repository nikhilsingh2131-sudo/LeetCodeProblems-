class Solution {
    public String longestPalindrome(String s) {
       

    if (s.length() <= 1)
        return s;

    String LPS = "";

    for (int i = 1; i < s.length(); i++) {

        // Consider odd length
        int low = i;
        int high = i;
        // Keep extending in both left and right directions till the
        // conditions for a palindrome are met
        while(s.charAt(low) == s.charAt(high)) {
            low--;
            high++;

            // Terminating condition if we reach the end/start of the string
            if (low == -1 || high == s.length())
                break;
        }

        // Indexes low and high can be used to extract the substring
        String palindrome = s.substring(low + 1, high);
        if (palindrome.length() > LPS.length()) {
            // Capture the longest palindrome found
            LPS = palindrome;
        }

        // Consider even length
        low = i - 1;
        high = i;
        while(s.charAt(low) == s.charAt(high)) {
            low--;
            high++;

            if (low == -1 || high == s.length())
                break;
        }

        palindrome = s.substring(low + 1, high);
        if (palindrome.length() > LPS.length()) {
            // Similarly, keep a track of the longest even length palindrome
            LPS = palindrome;
        }
    }

    return LPS;
}

}