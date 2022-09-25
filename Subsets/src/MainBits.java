/*
https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.List;

public class MainBits {
    public List<List<Integer>> subsets(int[] nums) {
        int length = 1 << nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int k = i;
            List<Integer> tmpList = new ArrayList<>();
            int index = 0;

            while (k > 0) {
                if ((k & 1) == 1) {
                    tmpList.add(nums[index]);
                }

                k >>= 1;
                index++;
            }

            ans.add(new ArrayList<>(tmpList));
        }

        return ans;
    }

    public static void main(String[] args) {
        MainBits m = new MainBits();

        System.out.println(m.subsets(new int[]{1, 2, 3}));
    }
}
