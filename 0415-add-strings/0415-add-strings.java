class Solution {
    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0) {

            int first = 0;
            int second = 0;

            if (i >= 0) {
                first = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                second = num2.charAt(j) - '0';
                j--;
            }

            int sum = first + second + carry;

            ans.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            ans.append(carry);
        }

        return ans.reverse().toString();
    }
}