/*
https://leetcode.com/problems/rotate-array/
 */
package arrays;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int size = nums.length;

        if (size < 2 || k == 0 || k == size)
            return;

        k %= size;

        int index = 0;
        int l = nums[index];

        int hits = 0;

        for (int jump = 0; jump < size; jump++) {
            int newIndex = (index + k) % size;
            int r = nums[newIndex];
            nums[newIndex] = l;
            l = r;
            if (newIndex == hits) {
                hits++;
                index = newIndex + 1;
                l = nums[index];
            } else {
                index = newIndex;
            }
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        ra.rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {-1, -100, 3, 99};
        ra.rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1, 2};
        ra.rotate(nums3, 3);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {1, 2, 3};
        ra.rotate(nums4, 2);
        System.out.println(Arrays.toString(nums4));


        int[] nums5 = {1, 2, 3, 4, 5, 6};
        ra.rotate(nums5, 1);
        System.out.println(Arrays.toString(nums5));

        int[] nums6 = {1, 2, 3, 4, 5, 6};
        ra.rotate(nums6, 2);
        System.out.println(Arrays.toString(nums6));

        int[] nums7 = {1, 2, 3, 4, 5, 6};
        ra.rotate(nums7, 3);
        System.out.println(Arrays.toString(nums7));

        int[] nums8 = {1, 2, 3};
        ra.rotate(nums8, 1);
        System.out.println(Arrays.toString(nums8));

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54};
        ra.rotate(nums9, 45);
        System.out.println(Arrays.toString(nums9));
    }
}
