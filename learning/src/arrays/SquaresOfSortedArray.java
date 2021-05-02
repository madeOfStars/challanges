/*
https://leetcode.com/problems/squares-of-a-sorted-array/
 */
package arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        if (nums.length == 1)
            return new int[]{nums[0] * nums[0]};

        int left = 0;
        int right = nums.length - 1;
        int indexResult = right;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[indexResult] = nums[left] * nums[left];
                left++;
            } else {
                result[indexResult] = nums[right] * nums[right];
                right--;
            }

            indexResult--;
        }

        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray ssa = new SquaresOfSortedArray();

        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(ssa.sortedSquares(nums1)));

        int[] nums2 = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(ssa.sortedSquares(nums2)));
    }
}
