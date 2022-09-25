/*
https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainBackTracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, 0, new LinkedList<>(), ans);

        return ans;
    }

    private void helper(int[] nums, int k, LinkedList<Integer> tmpList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(tmpList));
        for (int i = k; i < nums.length; i++) {
            tmpList.add(nums[i]);
            helper(nums, i + 1, tmpList, ans);
            tmpList.removeLast();
        }
    }

    public static void main(String[] args) {
        MainBackTracking m = new MainBackTracking();

        System.out.println(m.subsets(new int[]{1, 2, 3}));
    }
}
