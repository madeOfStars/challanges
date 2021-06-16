/*
https://leetcode.com/problems/minimum-size-subarray-sum/
 */
package arrays;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int size = nums.length;
        int sum = nums[0];
        int delta = size + 1;

        while (right < size && left < size) {
            if (sum >= target) {
                delta = Math.min(delta, right - left + 1);
                sum -= nums[left];
                left++;
            } else {
                right++;
                if (right < size) {
                    sum += nums[right];
                }
            }
        }

        return delta == size + 1 ? 0 : delta;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums4 = {1, 2, 3, 4, 5};

        System.out.println(m.minSubArrayLen(7, nums1));
        System.out.println(m.minSubArrayLen(4, nums2));
        System.out.println(m.minSubArrayLen(11, nums3));
        System.out.println(m.minSubArrayLen(11, nums4));
    }
}
