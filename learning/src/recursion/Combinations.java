/*
https://leetcode.com/problems/combinations/
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 1)
            return List.of(List.of(1));

        ArrayList<List<Integer>> allCombinations = new ArrayList<>();
        combine(1, n, k, allCombinations, new ArrayList<>());
        return allCombinations;
    }

    private void combine(int start, int n, int k, List<List<Integer>> allCombinations, List<Integer> combi) {
        for (int i = start; i <= n; i++) {
            combi.add(i);
            if (combi.size() == k)
                allCombinations.add(new ArrayList<>(combi));
            else
                combine(i + 1, n, k, allCombinations, combi);
            combi.remove(combi.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();

        System.out.println(c.combine(4, 2));
    }
}
