class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            int current = asteroids[i];

            // Collision tabhi hogi jab
            // stack ka top positive ho
            // aur current negative ho
            while (!st.isEmpty() && st.peek() > 0 && current < 0) {

                if (st.peek() < -current) {

                    // Stack wala asteroid destroy
                    st.pop();

                } else if (st.peek() == -current) {

                    // Dono destroy
                    st.pop();
                    current = 0;
                    break;

                } else {

                    // Current asteroid destroy
                    current = 0;
                    break;
                }
            }

            // Agar current asteroid destroy nahi hua
            if (current != 0) {
                st.push(current);
            }
        }

       
        int[] ans = new int[st.size()];

        int i = ans.length - 1;

        while (!st.isEmpty()) {
            ans[i] = st.pop();
            i--;
        }

        return ans;
    }
}