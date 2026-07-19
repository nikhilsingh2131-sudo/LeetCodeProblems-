

class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int as : asteroids) {

            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && as < 0) {

                if (st.peek() < -as) {
                    st.pop();
                }
                else if (st.peek() == -as) {
                    st.pop();
                    destroyed = true;
                    break;
                }
                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(as);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}