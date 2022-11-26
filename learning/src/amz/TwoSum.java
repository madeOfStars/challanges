/*
https://leetcode.com/problems/two-sum/
 */

package amz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int missingSum = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }

            map.put(missingSum, i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum m = new TwoSum();

        System.out.println(Arrays.toString(m.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(m.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(m.twoSum(new int[]{3, 3}, 6)));
    }
}
