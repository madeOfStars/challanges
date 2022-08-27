package graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraphDFS {
    private int count;

    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                count++;
                helper(i, adjList, visited);
            }
        }

        return count;
    }

    private void helper(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < adjList.get(node).size(); i++) {
            Integer value = adjList.get(node).get(i);
            if (!visited[value]) {
                helper(value, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraphDFS m = new NumberOfConnectedComponentsInAnUndirectedGraphDFS();

        int[][] edges1 = new int[][]{
                {0, 1},
                {1, 2},
                {3, 4}
        };

        System.out.println(m.countComponents(5, edges1)); //2

        int[][] edges2 = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(m.countComponents(5, edges2)); //1
    }
}
