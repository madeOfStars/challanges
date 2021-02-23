/*
https://leetcode.com/problems/sort-an-array/
 */
package recursion;

import java.util.Arrays;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1)
            return nums;

        int pivot = nums.length / 2;

        int[] leftArray = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] rightArray = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));

        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int leftPointer = 0, rightPointer = 0, resultPointer = 0;

        while (leftPointer < leftArray.length && rightPointer < rightArray.length) {
            if (leftArray[leftPointer] < rightArray[rightPointer])
                result[resultPointer++] = leftArray[leftPointer++];
            else
                result[resultPointer++] = rightArray[rightPointer++];
        }

        while (leftPointer < leftArray.length)
            result[resultPointer++] = leftArray[leftPointer++];

        while (rightPointer < rightArray.length)
            result[resultPointer++] = rightArray[rightPointer++];

        return result;
    }

    public static void main(String[] args) {
        SortAnArray sa = new SortAnArray();

        /*System.out.println(Arrays.toString(sa.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(sa.sortArray(new int[]{5, 1, 1, 2, 0, 0})));*/
        System.out.println(Arrays.toString(sa.sortArray(new int[]{-2, 3, -5})));
    }
}
