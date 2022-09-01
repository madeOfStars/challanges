package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindIfPathExistsInGraphBFS {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0)
            return false;

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Integer index = queue.poll();

            for (Integer node : adjList.get(index)) {
                if (node == destination)
                    return true;

                if (visited.contains(node))
                    continue;

                queue.add(node);
                visited.add(node);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraphBFS m = new FindIfPathExistsInGraphBFS();

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
