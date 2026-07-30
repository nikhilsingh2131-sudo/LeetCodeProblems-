class Solution {
    public String decodeString(String s) {

        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();

        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');

            } else if (ch == '[') {

                st1.push(num);
                num = 0;
                st2.push("[");

            } else if (Character.isLetter(ch)) {

                st2.push(String.valueOf(ch));

            } else if (ch == ']') {

                StringBuilder curr = new StringBuilder();

                while (!st2.isEmpty() && !st2.peek().equals("[")) {
                    curr.insert(0, st2.pop());   // reverse order maintain
                }

                st2.pop(); // remove "["

                int repeat = st1.pop();

                StringBuilder temp = new StringBuilder();

                for (int i = 0; i < repeat; i++) {
                    temp.append(curr);
                }

                st2.push(temp.toString());
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st2.isEmpty()) {
            ans.insert(0, st2.pop());
        }

        return ans.toString();
    }
}