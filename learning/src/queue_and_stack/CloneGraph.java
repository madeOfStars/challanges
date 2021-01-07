/*
https://leetcode.com/problems/clone-graph/
 */
package queue_and_stack;

import java.util.*;

public class CloneGraph {
    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraph(node, visited);
    }

    public static Node cloneGraph(Node node, Map<Node, Node> visited) {
        visited.put(node, new Node(node.val));

        for (Node neighbor : node.neighbors) {
            if (visited.containsKey(neighbor)) {
                visited.get(node).neighbors.add(visited.get(neighbor));
            } else {
                visited.get(node).neighbors.add(cloneGraph(neighbor, visited));
            }
        }

        return visited.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloneGraph = cloneGraph(node1);
        System.out.println(cloneGraph);
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
