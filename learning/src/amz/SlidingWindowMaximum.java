/*
https://leetcode.com/problems/sliding-window-maximum/
 */

package amz;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>(k);

        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            var value = nums[i];

            if (!deq.isEmpty() && value > nums[deq.peekLast()]) {
                while (!deq.isEmpty() && value > nums[deq.peekLast()]) {
                    deq.removeLast();
                }
            }
            deq.add(i);

            if (i >= k - 1) {
                ans[index++] = nums[deq.peekFirst()];
                if (deq.peekFirst() == i - k + 1) {
                    deq.pollFirst();
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum m = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // [3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1}, 1))); // [1]
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 1)));
    }
}
