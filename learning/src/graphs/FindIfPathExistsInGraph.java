package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return helper(source, adjList, visited, destination);
    }

    private boolean helper(int node, List<List<Integer>> adjList, Set<Integer> visited, int destination) {
        if (node == destination)
            return true;

        if (visited.contains(node))
            return false;

        visited.add(node);

        for (int link : adjList.get(node)) {
            var value = helper(link, adjList, visited, destination);
            if (value)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraph m = new FindIfPathExistsInGraph();

        int[][] edges1 = {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        System.out.println(m.validPath(3, edges1, 0, 2)); //true

        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };

        System.out.println(m.validPath(6, edges2, 0, 5)); //false
    }
}
