/*
https://leetcode.com/problems/course-schedule-ii/
 */

package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final Map<Integer, List<Integer>> adj = new HashMap<>();
        final int[] inDegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            var list = adj.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adj.put(src, list);
            inDegrees[dest]++;
        }

        final int[] ans = new int[numCourses];
        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegrees.length; i++) {
            int inDegree = inDegrees[i];
            if (inDegree == 0) {
                queue.add(i);
            }
        }

        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans[index++] = node;

            if (adj.containsKey(node)) {
                for (Integer neighbour : adj.get(node)) {
                    inDegrees[neighbour]--;

                    if (inDegrees[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        if (index == numCourses) {
            return ans;
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        CourseScheduleII m = new CourseScheduleII();

        int[][] prerequisites1 = {
                {1, 0}
        };

        System.out.println(Arrays.toString(m.findOrder(2, prerequisites1)));

        int[][] prerequisites2 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
        };

        System.out.println(Arrays.toString(m.findOrder(4, prerequisites2)));

        int[][] prerequisites3 = {};

        System.out.println(Arrays.toString(m.findOrder(1, prerequisites3)));
    }
}
