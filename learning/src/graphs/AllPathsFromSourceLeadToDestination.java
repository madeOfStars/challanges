package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        return helper(adjList, source, destination, new HashSet<>());
    }

    private boolean helper(List<List<Integer>> adjList, int start, int destination, Set<Integer> visited) {
        if (visited.contains(start)) {
            return false;
        }
        if (start == destination) {
            return adjList.get(destination).isEmpty();
        }
        visited.add(start);

        for (int next : adjList.get(start)) {

            if (!helper(adjList, next, destination, visited)) {
                return false;
            }
        }
        visited.remove(start);
        return adjList.get(start).size() > 0;
    }

    public static void main(String[] args) {
        AllPathsFromSourceLeadToDestination m = new AllPathsFromSourceLeadToDestination();

        int[][] edges1 = {
                {0, 1},
                {0, 2}
        };

        System.out.println(m.leadsToDestination(3, edges1, 0, 2)); // false

        int[][] edges2 = {
                {0, 1},
                {0, 3},
                {1, 2},
                {2, 1}
        };

        System.out.println(m.leadsToDestination(4, edges2, 0, 3)); // false

        int[][] edges3 = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3}
        };

        System.out.println(m.leadsToDestination(4, edges3, 0, 3)); // true

        int[][] edges4 = {
                {0, 1},
                {1, 1},
                {1, 2},
        };

        System.out.println(m.leadsToDestination(4, edges4, 0, 2)); // false
    }
}
