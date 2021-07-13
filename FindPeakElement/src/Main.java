/*
https://leetcode.com/problems/find-peak-element/
 */
public class Main {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (right - left == 1) {
                if (nums[right] > nums[left])
                    return right;
                else
                    return left;
            }

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid + 1] > nums[mid])
                left = mid;
            else
                right = mid;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(m.findPeakElement(nums1));

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(m.findPeakElement(nums2));

        int[] nums3 = {1, 2};
        System.out.println(m.findPeakElement(nums3));

        int[] nums4 = {1, 2, 3};
        System.out.println(m.findPeakElement(nums4));
    }
}
