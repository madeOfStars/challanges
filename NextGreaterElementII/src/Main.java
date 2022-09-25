/*
https://leetcode.com/problems/next-greater-element-ii/
 */

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % n);
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        //System.out.println(Arrays.toString(m.nextGreaterElements(new int[]{1, 2, 1})));
        //System.out.println(Arrays.toString(m.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(m.nextGreaterElements(new int[]{3, 5, 8, 1, 2})));
    }
}
