/*
https://leetcode.com/problems/combination-sum-ii/
 */
import java.util.*;

public class Main {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> all = new LinkedList<>();

        helper(candidates, target, all, new LinkedList<>(), 0);

        return new ArrayList<>(all);
    }

    private void helper(int[] candidates, int target, LinkedList<List<Integer>> all, LinkedList<Integer> tmp, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            if (target - candidates[i] < 0)
                return;

            tmp.addLast(candidates[i]);

            if (target - candidates[i] == 0) {
                all.addLast(new LinkedList<>(tmp));
            } else {
                helper(candidates, target - candidates[i], all, tmp, i + 1);
            }

            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] arr1 = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(m.combinationSum2(arr1, 8));

        int[] arr2 = {2, 5, 2, 1, 2};
        System.out.println(m.combinationSum2(arr2, 5));
    }
}
