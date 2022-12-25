/*
https://leetcode.com/problems/meeting-rooms-ii/
 */

package amz;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1)
            return 1;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            start[i] = interval[0];
            end[i] = interval[1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int ans = 0;
        int startPointer = 0;
        int endPointer = 0;

        while (startPointer < intervals.length) {
            if (start[startPointer] >= end[endPointer]) {
                ans--;
                endPointer++;
            }

            ans++;
            startPointer++;
        }

        return ans;
    }

    public int minMeetingRooms2(int[][] intervals) {
        int[] ans = new int[1_000_000];

        int max = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            for (int i = start; i < end; i++) {
                ans[i]++;
                max = Math.max(max, ans[i]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MeetingRoomsII m = new MeetingRoomsII();

        int[][] intervals1 = new int[][]{
                {0, 30},
                {5, 10},
                {15, 20},
        };

        System.out.println(m.minMeetingRooms(intervals1)); //2

        int[][] intervals2 = new int[][]{
                {7, 10},
                {2, 4},
        };

        System.out.println(m.minMeetingRooms(intervals2)); //1

        int[][] intervals3 = new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {1, 6},
        };

        System.out.println(m.minMeetingRooms(intervals3)); // 5

        int[][] intervals4 = new int[][]{
                {13, 15},
                {1, 13},
        };

        System.out.println(m.minMeetingRooms(intervals4)); // 1

        int[][] intervals5 = new int[][]{
                {9, 10},
                {4, 9},
                {4, 17},
        };

        System.out.println(m.minMeetingRooms(intervals5)); // 2

        int[][] intervals6 = new int[][]{
                {2, 11},
                {6, 16},
                {11, 16},
        };

        System.out.println(m.minMeetingRooms(intervals6)); // 2

        int[][] intervals7 = new int[][]{
                {6, 17},
                {8, 9},
                {11, 12},
                {6, 9},
        };

        System.out.println(m.minMeetingRooms(intervals7)); // 3
    }
}
