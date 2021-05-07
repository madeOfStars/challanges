/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
package arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i - 1];
                k++;
            }
        }

        nums[k] = nums[nums.length - 1];

        return k + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();

        int[] nums1 = new int[]{1, 1, 2};
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(rd.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));

        System.out.println(rd.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
