/*
https://leetcode.com/problems/map-sum-pairs/
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MapSum {

    private static class TrieNode {
        private Map<Character, TrieNode> links = new HashMap<>();
        private int sum;
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;

        for (Character c : key.toCharArray()) {
            if (!node.links.containsKey(c)) {
                node.links.put(c, new TrieNode());
            }

            node = node.links.get(c);
        }

        node.sum = val;
    }

    public int sum(String prefix) {
        int ans = 0;

        TrieNode node = root;

        for (Character c : prefix.toCharArray()) {
            if (!node.links.containsKey(c))
                return 0;

            node = node.links.get(c);
        }

        ans += node.sum;

        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TrieNode polledNode = queue.poll();

                for (TrieNode link : polledNode.links.values()) {
                    ans += link.sum;
                    queue.add(link);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
