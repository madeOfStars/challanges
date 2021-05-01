/*
https://leetcode.com/problems/the-skyline-problem/
 */

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        int index = 0;
        Borders[] borders = new Borders[buildings.length * 2];

        for (int[] building : buildings) {
            borders[index] = new Borders(building[0], building[2], true);
            borders[index + 1] = new Borders(building[1], building[2], false);

            index += 2;
        }
        Arrays.sort(borders);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int max = 0;

        for (Borders border : borders) {
            if (border.isStart) {
                map.compute(border.height, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else {
                map.compute(border.height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
            }

            int currHeight = map.lastKey();

            if (currHeight != max) {
                result.add(List.of(border.border, currHeight));
                max = currHeight;
            }
        }

        return result;
    }

    private static class Borders implements Comparable<Borders> {
        int border;
        int height;
        boolean isStart;

        public Borders(int border, int height, boolean isStart) {
            this.border = border;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Borders o) {
            if (o.border != this.border)
                return this.border - o.border;

            return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
        }
    }

    public static void main(String[] args) {
        TheSkylineProblem sp = new TheSkylineProblem();
        int[][] buildings1 = new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8},
        };

        int[][] buildings2 = new int[][]{
                {0, 2, 3},
                {2, 5, 3},
        };

        int[][] buildings3 = new int[][]{
                {0, 2147483647, 2147483647},
        };

        int[][] buildings4 = new int[][]{
                {1, 2, 1},
                {1, 2, 2},
                {1, 2, 3},
        };

        int[][] buildings5 = new int[][]{
                {0, 2, 3},
                {2, 4, 3},
                {4, 6, 3},
        };

        int[][] buildings6 = new int[][]{
                {1, 2, 1},
                {1, 2, 2},
                {1, 2, 3},
                {2, 3, 1},
                {2, 3, 2},
                {2, 3, 3},
        };

        int[][] buildings7 = new int[][]{
                {4, 9, 10},
                {4, 9, 15},
                {4, 9, 12},
                {10, 12, 10},
                {10, 12, 8},
        };

        System.out.println(sp.getSkyline(buildings1));
        System.out.println(sp.getSkyline(buildings2));
        System.out.println(sp.getSkyline(buildings3));
        System.out.println(sp.getSkyline(buildings4));
        System.out.println(sp.getSkyline(buildings5));
        System.out.println(sp.getSkyline(buildings6));
        System.out.println(sp.getSkyline(buildings7));
    }
}
