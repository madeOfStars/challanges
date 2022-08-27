/*
https://leetcode.com/problems/graph-valid-tree/
 */

package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTreeDFS {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        helper(0, adjacencyList, visited);

        return visited.size() == n;
    }

    private void helper(int node, List<List<Integer>> adjacencyList, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        for (int neighbour : adjacencyList.get(node)) {
            helper(neighbour, adjacencyList, visited);
        }
    }

    public static void main(String[] args) {
        GraphValidTreeDFS gvt = new GraphValidTreeDFS();

        int[][] edges1 = new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };

        System.out.println(gvt.validTree(5, edges1));  //true

        int[][] edges2 = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        };

        System.out.println(gvt.validTree(5, edges2));  //false
    }
}
