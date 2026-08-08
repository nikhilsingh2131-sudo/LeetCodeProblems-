class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String op : operations) {

            // Number
            if (!op.equals("+") && !op.equals("D") && !op.equals("C")) {

                int num = Integer.parseInt(op);
                st.push(num);
            }

            // Sum of last two scores
            else if (op.equals("+")) {

                int last = st.pop();
                int secondLast = st.peek();

                int sum = last + secondLast;

                // Last score wapas push karo
                st.push(last);

                // New score push karo
                st.push(sum);
            }

            // Double previous score
            else if (op.equals("D")) {

                int prev = st.peek();

                st.push(2 * prev);
            }

            // Cancel previous score
            else if (op.equals("C")) {

                st.pop();
            }
        }

        int res = 0;

        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
}