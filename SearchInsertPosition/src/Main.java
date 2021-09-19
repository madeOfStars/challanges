/*
https://leetcode.com/problems/search-insert-position/
 */
public class Main {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(m.searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(m.searchInsert(new int[]{1, 3, 5, 6}, 7)); // 4
        System.out.println(m.searchInsert(new int[]{1, 3, 5, 6}, 0)); // 0
        System.out.println(m.searchInsert(new int[]{1}, 0)); // 0
    }
}
