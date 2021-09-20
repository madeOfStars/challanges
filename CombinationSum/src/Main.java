/*
https://leetcode.com/problems/combination-sum/
 */
import java.util.*;

public class Main {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), all, 0);
        return all;
    }

    private void helper(int[] candidates, int target, List<Integer> tmpList, List<List<Integer>> all, int index) {
        if (target < 0)
            return;

        for (int i = index; i < candidates.length; i++) {
            tmpList.add(candidates[i]);

            int newTarget = target - candidates[i];
            if (newTarget == 0) {
                all.add(new ArrayList<>(tmpList));
            } else {
                helper(candidates, newTarget, tmpList, all, i);
            }

            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(m.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(m.combinationSum(new int[]{2}, 1));
        System.out.println(m.combinationSum(new int[]{1}, 1));
        System.out.println(m.combinationSum(new int[]{1, 1}, 2));
        System.out.println(m.combinationSum(new int[]{1, 2}, 4));
        System.out.println(m.combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9));
    }
}
