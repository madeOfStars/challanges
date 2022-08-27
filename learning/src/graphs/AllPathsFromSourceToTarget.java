/*
https://leetcode.com/problems/all-paths-from-source-to-target/
 */

package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, graph, result, new LinkedList<>());
        return result;
    }

    private void helper(int node, int[][] graph, List<List<Integer>> result, LinkedList<Integer> tmpList) {
        tmpList.add(node);

        if (node == graph.length - 1) {
            result.add(new ArrayList<>(tmpList));
        }

        for (int link : graph[node]) {
            helper(link, graph, result, tmpList);
            tmpList.removeLast();
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget m = new AllPathsFromSourceToTarget();

        int[][] graph1 = {
                {1, 2},
                {3},
                {3},
                {}
        };

        System.out.println(m.allPathsSourceTarget(graph1));

        int[][] graph2 = {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };

        System.out.println(m.allPathsSourceTarget(graph2));
    }
}
