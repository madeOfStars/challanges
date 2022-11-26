/*
https://leetcode.com/problems/minimum-height-trees/
 */

package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n < 2) {
            return IntStream.range(0, n).boxed().toList();
        }

        final List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (adjList.get(i).size() == 1)
                leaves.add(i);

        int leftNodes = n;
        while (leftNodes > 2) {
            leftNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (Integer leaf : leaves) {
                int neighbour = adjList.get(leaf).get(0);
                adjList.get(neighbour).remove(leaf);

                if (adjList.get(neighbour).size() == 1) {
                    newLeaves.add(neighbour);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
