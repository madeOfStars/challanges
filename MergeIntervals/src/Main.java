/*
https://leetcode.com/problems/merge-intervals/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> tempList = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                int[] holder = new int[2];
                holder[0] = start;
                holder[1] = end;
                tempList.add(holder);

                start = intervals[i][0];
            }
            end = Math.max(intervals[i][1], end);
        }

        int[] holder = new int[2];
        holder[0] = start;
        holder[1] = end;

        tempList.add(holder);

        int[][] result = new int[tempList.size()][2];

        for (int i = 0; i < tempList.size(); i++) {
            result[i] = tempList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] intervals1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println(Arrays.deepToString(m.merge(intervals1))); // [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {
                {1, 4},
                {4, 5},
        };

        System.out.println(Arrays.deepToString(m.merge(intervals2))); // [[1, 5]]

        int[][] intervals3 = {
                {1, 4},
        };

        System.out.println(Arrays.deepToString(m.merge(intervals3))); // 1,4

        int[][] intervals4 = {
                {1, 4},
                {0, 4},
        };

        System.out.println(Arrays.deepToString(m.merge(intervals4))); // 0,4

        int[][] intervals5 = {
                {1, 4},
                {2, 3},
        };

        System.out.println(Arrays.deepToString(m.merge(intervals5))); // 1, 4
    }
}
