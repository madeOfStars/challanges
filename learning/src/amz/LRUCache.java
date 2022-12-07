/*
https://leetcode.com/problems/lru-cache/
 */

package amz;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        private final int key;
        private int val;
        private Node prev;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node firstNode;
    private final Node lastNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        firstNode = new Node(-1, -1);
        lastNode = new Node(-2, -2);
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            final Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node n;
        if (get(key) != -1) {
            n = map.get(key);
            n.val = value;
            removeNode(n);
            addNode(n);
        } else {
            n = new Node(key, value);

            if (map.size() == capacity) {
                map.remove(firstNode.next.key);
                removeNode(firstNode.next);
            }
            addNode(n);
            map.put(key, n);
        }

    }

    private void addNode(Node node) {
        lastNode.prev.next = node;
        node.next = lastNode;
        node.prev = lastNode.prev;
        lastNode.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache m = new LRUCache(2);

        /*m.put(1, 1);
        m.put(2, 2);
        System.out.println(m.get(1));
        m.put(3, 3);
        System.out.println(m.get(2));
        m.put(4,4);
        System.out.println(m.get(1));
        System.out.println(m.get(3));
        System.out.println(m.get(4));*/

        m.put(1, 0);
        m.put(2, 2);
        System.out.println(m.get(1));
        m.put(3, 3);
        System.out.println(m.get(2));
        m.put(4, 4);
        System.out.println(m.get(1));
        System.out.println(m.get(4));
        System.out.println(m.get(4));
    }
}
