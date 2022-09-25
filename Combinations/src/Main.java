/*
https://leetcode.com/problems/combinations/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, ans, new LinkedList<>(), 1);
        return ans;
    }

    private void helper(int n, int k, List<List<Integer>> ans, LinkedList<Integer> tmp, int index) {
        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
        }

        for (int i = index; i <= n; i++) {
            tmp.add(i);
            helper(n, k, ans, tmp, i + 1);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.combine(4, 3));
    }
}
