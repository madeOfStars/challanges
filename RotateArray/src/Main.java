/*
https://leetcode.com/problems/rotate-array/
 */

import java.util.Arrays;

public class Main {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        m.rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {-1};
        m.rotate(nums2, 1);
        System.out.println(Arrays.toString(nums2));
    }
}
