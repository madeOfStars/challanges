/*
https://leetcode.com/problems/sliding-window-maximum/
 */

package amz;

import java.util.Arrays;

public class SlidingWindowMaximumDP {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];

        int[] right = new int[n];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            }
            else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            ans[i] = Math.max(left[i + k - 1], right[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        SlidingWindowMaximumDP m = new SlidingWindowMaximumDP();
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // [3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{1}, 1))); // [1]
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 1)));
    }
}
