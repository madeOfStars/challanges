/*
https://leetcode.com/problems/maximum-subarray/
 */

public class Main {
    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        int i = 1;

        while (i < nums.length) {
            int negativeSum = 0;
            while (i < nums.length && nums[i] < 0 && sum > 0) {
                negativeSum += nums[i];
                i++;
            }

            if (i < nums.length)
                if (sum + negativeSum < 0)
                    sum = nums[i];
                else {
                    sum += nums[i] + negativeSum;
                }

            max = Math.max(sum, max);
            i++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{-2147483647, -5};
        int[] nums5 = new int[]{-2, 5};
        int[] nums6 = new int[]{-2147483647};

        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
        System.out.println(maxSubArray(nums5));
        System.out.println(maxSubArray(nums6));
    }
}
