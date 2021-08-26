/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
import java.util.Arrays;

public class Main {
    private int getFirst(int[] nums, int target) {
        int first = nums.length;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                first = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        if (nums.length == 1 && nums[0] == target)
            return new int[]{0, 0};

        int first = getFirst(nums, target);
        int last = getFirst(nums, target + 1) - 1;

        if (first <= last) {
            return new int[]{first, last};
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] arr1 = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(m.searchRange(arr1, 8)));

        int[] arr2 = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(m.searchRange(arr2, 6)));

        int[] arr3 = {1};
        System.out.println(Arrays.toString(m.searchRange(arr3, 1)));

        int[] arr4 = {2, 2};
        System.out.println(Arrays.toString(m.searchRange(arr4, 2)));
    }
}
