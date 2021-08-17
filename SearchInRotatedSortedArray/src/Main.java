/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Main {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(m.search(nums1, 0));

        int[] nums2 = {1, 3};
        System.out.println(m.search(nums2, 3));

        int[] nums3 = {1, 3};
        System.out.println(m.search(nums3, 0));

        int[] nums4 = {3, 1};
        System.out.println(m.search(nums4, 3));

        int[] nums5 = {3, 1};
        System.out.println(m.search(nums5, 1));
    }
}
