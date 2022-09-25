/*
https://leetcode.com/problems/4sum-ii/
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                count += map.getOrDefault(-(i + j), 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{-2, -1};
        int[] num3 = new int[]{-1, 2};
        int[] num4 = new int[]{0, 2};

        System.out.println(m.fourSumCount(num1, num2, num3, num4));
    }
}
