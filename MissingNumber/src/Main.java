/*
https://leetcode.com/problems/missing-number/
 */
public class Main {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = new int[]{3, 0, 1};
        System.out.println(m.missingNumber(nums1)); //2

        int[] nums2 = new int[]{0, 1};
        System.out.println(m.missingNumber(nums2)); //2

        int[] nums3 = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(m.missingNumber(nums3)); //8

        int[] nums4 = new int[]{2, 0};
        System.out.println(m.missingNumber(nums4)); //1
    }
}
