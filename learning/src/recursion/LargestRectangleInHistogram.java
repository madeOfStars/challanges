/*
https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
package recursion;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int newLength = heights.length + 1;
        int[] newHeights = new int[newLength];
        System.arraycopy(heights, 0, newHeights, 0, heights.length);
        newHeights[newLength - 1] = 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < newHeights.length) {
            if (stack.isEmpty() || newHeights[i] > newHeights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                Integer top = stack.pop();
                max = Math.max(max, newHeights[top] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();

        System.out.println(lr.largestRectangleArea(new int[]{2, 3, 1, 3, 4, 1, 2}));
    }
}
