class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            mapT[ch]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {

            mapS[s.charAt(right)]++;

            while (contains(mapS, mapT)) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                mapS[s.charAt(left)]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }

    private boolean contains(int[] mapS, int[] mapT) {

        for (int i = 0; i < 256; i++) {
            if (mapT[i] > mapS[i]) {
                return false;
            }
        }

        return true;
    }
}