class Solution {
    public String licenseKeyFormatting(String s, int k) {

        s = s.toUpperCase().replace("-", "");

        String ans = "";
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            ans = s.charAt(i) + ans;
            count++;

            if (count == k && i != 0) {
                ans = "-" + ans;
                count = 0;
            }
        }

        return ans;
    }
}