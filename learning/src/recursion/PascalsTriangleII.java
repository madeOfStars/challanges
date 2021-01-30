/*
https://leetcode.com/problems/pascals-triangle-ii/
 */
package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return List.of(1);
        Map<String, Integer> cache = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < rowIndex; i++) {
            result.add(helper(rowIndex, i, cache));
        }
        result.add(1);
        return result;
    }

    private int helper(int i, int j, Map<String, Integer> cache) {
        if (i == 1 || j == 0 || i == j)
            return 1;

        String key = i + "|" + j;

        if (!cache.containsKey(key))
            cache.put(key, helper(i - 1, j - 1, cache) + helper(i - 1, j, cache));

        return cache.get(key);
    }

    public static void main(String[] args) {
        PascalsTriangleII pt = new PascalsTriangleII();
        System.out.println(pt.getRow(30));
    }
}
