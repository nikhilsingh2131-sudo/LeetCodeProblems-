import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<String> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        String str = "";
        int n = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Digit
            if (Character.isDigit(ch)) {

                n = n * 10 + (ch - '0');

            }
            // Opening bracket
            else if (ch == '[') {

                st1.push(str);
                st2.push(n);

                str = "";
                n = 0;

            }
            // Closing bracket
            else if (ch == ']') {

                String prev = st1.pop();
                int repeat = st2.pop();

                StringBuilder res = new StringBuilder();

                res.append(prev);

                for (int j = 0; j < repeat; j++) {
                    res.append(str);
                }

                str = res.toString();

            }
            // Character
            else {

                str = str + ch;

            }
        }

        return str;
    }
}