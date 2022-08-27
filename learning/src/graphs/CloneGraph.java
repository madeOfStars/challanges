package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    static class Node {
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

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }


        return helper(node, new HashMap<>());
    }

    private Node helper(Node node, Map<Integer, Node> visited) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);

        for (Node neighbor : node.neighbors) {
            Node child = helper(neighbor, visited);
            newNode.neighbors.add(child);
//            return child;
        }

        return newNode;
    }

    public static void main(String[] args) {
        CloneGraph m = new CloneGraph();

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

        Node cloneGraph = m.cloneGraph(node1);
        System.out.println(cloneGraph);
    }
}
