/*
https://leetcode.com/problems/combination-sum-iii/
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> all = new ArrayList<>();
        helper(k, n, 1, all, new LinkedList<>());
        return all;
    }

    private void helper(int k, int n, int start, List<List<Integer>> all, LinkedList<Integer> tmpList) {
        if (n < 0)
            return;

        for (int i = start; i < 10; i++) {
            tmpList.addLast(i);

            if (tmpList.size() == k && n - i == 0) {
                all.add(new ArrayList<>(tmpList));
            } else {
                helper(k, n - i, i + 1, all, tmpList);
            }

            tmpList.removeLast();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.combinationSum3(3, 7));
        System.out.println(m.combinationSum3(3, 9));
        System.out.println(m.combinationSum3(4, 1));
        System.out.println(m.combinationSum3(3, 2));
        System.out.println(m.combinationSum3(9, 45));
    }
}
