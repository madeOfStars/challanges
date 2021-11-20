/*
https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class Main {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid;
                    ans = nums[right];
                } else {
                    right = mid;
                    ans = nums[left];
                }

            } else {
                if (nums[mid] == nums[mid + 1]) {
                    right = mid;
                    ans = nums[left];
                } else {
                    left = mid;
                    ans = nums[right];
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(m.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(m.singleNonDuplicate(new int[]{1, 1, 2}));
        System.out.println(m.singleNonDuplicate(new int[]{1, 1, 2, 2, 3}));
        System.out.println(m.singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
    }
}
