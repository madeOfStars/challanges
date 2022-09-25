/*
https://leetcode.com/problems/remove-covered-intervals/
 */

import java.util.Arrays;

public class Main {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int count = 0;
        int interval = 0;

        for (int[] currInterval : intervals) {
            int end = currInterval[1];

            if (interval < end) {
                count++;
                interval = end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[][] inter = new int[][]{
                {1, 4},
                {3, 6},
                {2, 8},
        };

        System.out.println(m.removeCoveredIntervals(inter));
    }
}
