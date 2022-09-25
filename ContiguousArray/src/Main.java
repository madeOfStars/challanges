/*
https://leetcode.com/problems/contiguous-array/
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            count += num == 1 ? 1 : -1;

            if (map.containsKey(count)) {
                ans = Math.max(ans, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.findMaxLength(new int[]{0, 1}));
        System.out.println(m.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(m.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}
