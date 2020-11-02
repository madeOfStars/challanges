/*
https://leetcode.com/problems/range-sum-query-immutable/
 */

public class Main {
    private static class NumArray {
        private final int[] sumArray;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                sumArray = new int[0];
                return;
            }

            sumArray = new int[nums.length];
            sumArray[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                sumArray[i] = sumArray[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0)
                return sumArray[j];

            return sumArray[j] - sumArray[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums1);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
