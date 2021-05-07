/*
https://leetcode.com/problems/merge-sorted-array/
 */
package arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int total = m + n - 1;

        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
                nums1[total] = nums1[left];
                left--;
            } else {
                nums1[total] = nums2[right];
                right--;
            }
            total--;
        }

        if (right >= 0)
            System.arraycopy(nums2, 0, nums1, 0, right + 1);
    }

    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();

        int[] num1 = new int[]{7,8,9,0,0,0};
        int[] num2 = new int[]{2,5,6};

        msa.merge(num1, 3, num2, 3);

        System.out.println(Arrays.toString(num1));
    }
}
