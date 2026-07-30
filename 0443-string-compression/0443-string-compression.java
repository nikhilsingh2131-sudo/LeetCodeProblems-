class Solution {
    public int compress(char[] chars) {

        int left = 0;
        int right = 0;
        int write = 0;

        while (right < chars.length) {

            int count = 0;

            // Count same characters
            while (right < chars.length && chars[left] == chars[right]) {
                count++;
                right++;
            }

            // Write character
            chars[write++] = chars[left];

            // Write count if greater than 1
            if (count > 1) {
                String str = String.valueOf(count);

                for (char ch : str.toCharArray()) {
                    chars[write++] = ch;
                }
            }

            left = right;
        }

        return write;
    }
}