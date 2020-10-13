/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

import java.util.Arrays;

public class Main {
    public static int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];

            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            } else if (sum < target) {
                leftIndex++;
            } else
                rightIndex--;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int[] nums2 = new int[]{2, 3, 4};
        int[] nums3 = new int[]{-1, 0};

        System.out.println(Arrays.toString(twoSum(nums1, 9)));
        System.out.println(Arrays.toString(twoSum(nums2, 6)));
        System.out.println(Arrays.toString(twoSum(nums3, -1)));
    }
}
