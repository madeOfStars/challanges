/*
https://leetcode.com/problems/word-search-ii/
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        createTrie(trie, words);
        Set<String> ans = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (trie.get(board[i][j]) != null) {
                    boolean[][] visited = new boolean[board.length][board[i].length];

                    helper(board, i, j, trie, visited, ans);
                }
            }
        }

        return new ArrayList<>(ans);
    }

    private void helper(char[][] board, int i, int j, TrieNode node, boolean[][] visited, Set<String> ans) {
        if (!isValid(board, i, j) || visited[i][j]) {
            return;
        }

        if (node.get(board[i][j]) == null) {
            return;
        }

        visited[i][j] = true;

        if (node.get(board[i][j]) != null && node.get(board[i][j]).word != null) {
            ans.add(node.get(board[i][j]).word);
        }

        helper(board, i, j - 1, node.get(board[i][j]), visited, ans);
        helper(board, i - 1, j, node.get(board[i][j]), visited, ans);
        helper(board, i, j + 1, node.get(board[i][j]), visited, ans);
        helper(board, i + 1, j, node.get(board[i][j]), visited, ans);

        visited[i][j] = false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length;
    }

    private void createTrie(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (node.get(c) == null) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.word = word;
        }
    }

    private static class TrieNode {

        private final Map<Character, TrieNode> links;
        private String word;

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
        Main m = new Main();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        System.out.println(m.findWords(board, new String[]{"oath", "pea", "eat", "rain", "oa", "oaa"}));
    }
}
