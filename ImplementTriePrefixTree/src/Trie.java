/*
https://leetcode.com/problems/implement-trie-prefix-tree/
 */
import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.links.containsKey(c)) {
                curr.put(c, new TrieNode());
            }

            curr = curr.get(c);
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.links.containsKey(c))
                return null;

            curr = curr.get(c);
        }
        return curr;
    }

    private static class TrieNode {

        private final Map<Character, TrieNode> links;
        private boolean isEnd;

        public TrieNode() {
            links = new HashMap<>();
        }

        public TrieNode get(char ch) {
            return links.get(ch);
        }

        public void put(char ch, TrieNode node) {
            links.put(ch, node);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
