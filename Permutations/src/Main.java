/*
https://leetcode.com/problems/permutations/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, ans, new LinkedList<>(), used);
        return ans;
    }

    private void helper(int[] nums, List<List<Integer>> ans, LinkedList<Integer> tmp, boolean[] used) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!used[i]) {
                used[i] = true;
                tmp.add(num);
                helper(nums, ans, tmp, used);
                tmp.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.permute(new int[]{1, 2, 3}));
    }
}
