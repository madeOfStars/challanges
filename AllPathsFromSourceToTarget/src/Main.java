/*
https://leetcode.com/problems/all-paths-from-source-to-target/
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> tmpList = new LinkedList<>();
        tmpList.add(0);
        helper(0, graph, ans, tmpList);
        return ans;
    }

    private void helper(int i, int[][] graph, List<List<Integer>> ans, LinkedList<Integer> tmpList) {
        for (int j = 0; j < graph[i].length; j++) {
            int node = graph[i][j];
            tmpList.add(node);

            if (node == graph.length - 1) {
                ans.add(new ArrayList<>(tmpList));
            } else {
                helper(node, graph, ans, tmpList);
            }

            tmpList.removeLast();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] graph1 = new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        };

        System.out.println(m.allPathsSourceTarget(graph1));

        int[][] graph2 = new int[][]{
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };

        System.out.println(m.allPathsSourceTarget(graph2));
    }
}
