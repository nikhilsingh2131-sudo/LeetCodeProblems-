class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nextGreaterElements = new int[nums2.length];

        Stack<Integer> helperStack = new Stack<>();

        // nums2 ko right se left traverse karenge
        for (int i = nums2.length - 1; i >= 0; i--) {

            int element = nums2[i];

            // Chhote ya equal elements ko remove karo
            while (!helperStack.isEmpty() &&
                   helperStack.peek() <= element) {

                helperStack.pop();
            }

            // Stack empty hai -> koi greater element nahi
            if (helperStack.isEmpty()) {
                nextGreaterElements[i] = -1;
            }
            // Stack ka top hi next greater element hai
            else {
                nextGreaterElements[i] = helperStack.peek();
            }

            // Current element ko stack mein daalo
            helperStack.push(element);
        }

        // nums1 ke answers
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    ans[i] = nextGreaterElements[j];
                    break;
                }
            }
        }

        return ans;
    }
}