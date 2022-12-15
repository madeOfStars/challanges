/*
https://leetcode.com/problems/course-schedule/
 */

package amz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int needed = pre[1];
            inDegree[pre[0]]++;
            var dependencies = adjList.getOrDefault(needed, new ArrayList<>());
            dependencies.add(pre[0]);
            adjList.put(needed, dependencies);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            int degree = inDegree[i];
            if (degree == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            return false;
        }

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (adjList.containsKey(node)) {
                for (int neighbour : adjList.get(node)) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        for (int degree : inDegree) {
            if (degree != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule m = new CourseSchedule();

        System.out.println(m.canFinish(2, new int[][]{
                {1, 0}
        }));

        System.out.println(m.canFinish(2, new int[][]{
                {1, 0},
                {0, 1}
        }));
    }
}
