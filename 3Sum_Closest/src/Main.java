/*
https://leetcode.com/problems/3sum-closest/
 */

import java.util.Arrays;

public class Main {
    public static int threeSumClosest(int[] nums, int target) {
        int minDiff = 10000;
        int wantedSum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int leftPosition = i + 1;
                int rightPosition = nums.length - 1;

                while (leftPosition < rightPosition) {
                    int sum = nums[i] + nums[leftPosition] + nums[rightPosition];
                    if (minDiff > Math.abs(target - sum)) {
                        minDiff = Math.abs(target - sum);
                        wantedSum = sum;
                    }
                    if (sum < target)
                        leftPosition++;
                    else
                        rightPosition--;
                }
            }
        }

        return wantedSum;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 2, 1, -4};

        System.out.println(threeSumClosest(nums1, 1));
    }
}
