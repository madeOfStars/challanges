/*
https://leetcode.com/problems/3sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int leftPosition = i + 1;
                int rightPosition = nums.length - 1;

                while (leftPosition < rightPosition) {
                    if (nums[leftPosition] + nums[rightPosition] == -1 * nums[i]) {
                        result.add(List.of(nums[i], nums[leftPosition], nums[rightPosition]));

                        while (leftPosition < rightPosition && nums[leftPosition] == nums[leftPosition + 1])
                            leftPosition++;

                        while (leftPosition < rightPosition && nums[rightPosition] == nums[rightPosition - 1])
                            rightPosition--;

                        leftPosition++;
                        rightPosition--;
                    } else if (nums[leftPosition] + nums[rightPosition] < -1 * nums[i])
                        leftPosition++;
                    else
                        rightPosition--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{};
        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{0, 0, 0, 0};
        int[] nums5 = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}; //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]

        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
        System.out.println(threeSum(nums4));
        System.out.println(threeSum(nums5));
    }
}
