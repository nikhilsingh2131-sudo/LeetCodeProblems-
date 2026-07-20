import java.util.Stack;

class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            // Agar i == n hai to currentHeight = 0 lete hain
            // Taaki stack ke saare remaining elements process ho jaaye.
            int currentHeight;

            if (i == n) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            // Jab current bar chhoti ho stack ke top se
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {

                // Jis bar ka rectangle nikalna hai
                int rectangleHeight = heights[stack.pop()];

                // Right boundary
                int rightBoundary = i;

                // Left boundary
                int leftBoundary;

                if (stack.isEmpty()) {
                    leftBoundary = -1;
                } else {
                    leftBoundary = stack.peek();
                }

                // Rectangle ki width
                int rectangleWidth = rightBoundary - leftBoundary - 1;

                // Area
                int rectangleArea = rectangleHeight * rectangleWidth;

                // Maximum area update
                maxArea = Math.max(maxArea, rectangleArea);
            }

            // Current index stack me push karo
            stack.push(i);
        }

        return maxArea;
    }
}