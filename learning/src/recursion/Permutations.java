/*
https://leetcode.com/problems/permutations/
 */
package recursion;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1)
            return List.of(List.of(1));

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        permute(nums, result, new ArrayList<>(), used);

        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> perm, boolean[] used) {

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                perm.add(nums[i]);
                used[i] = true;

                if (perm.size() == nums.length) {
                    result.add(new ArrayList<>(perm));
                }
                else {
                    permute(nums, result, perm, used);
                }
                used[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();

        System.out.println(p.permute(new int[]{1, 2, 3}));
    }
}
