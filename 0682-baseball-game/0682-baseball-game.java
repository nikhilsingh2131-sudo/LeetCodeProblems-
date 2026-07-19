import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String x : operations) {

            if (x.equals("+")) {
                int first = st.pop();
                int second = st.peek();

                int sum = first + second;

                st.push(first);
                st.push(sum);

            } else if (x.equals("D")) {
                st.push(2 * st.peek());

            } else if (x.equals("C")) {
                st.pop();

            } else {
                st.push(Integer.parseInt(x));
            }
        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}