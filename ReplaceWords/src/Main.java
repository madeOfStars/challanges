/*
https://leetcode.com/problems/replace-words/
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static class TrieNode {
        private Map<Character, TrieNode> map = new HashMap<>();
        private String word;
    }

    private TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {

        for (String word : dictionary) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (!node.map.containsKey(c)) {
                    node.map.put(c, new TrieNode());
                }

                node = node.map.get(c);
            }
            node.word = word;
        }

        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");

        for (String word : words) {
            TrieNode node = root;

            if (sb.length() > 0)
                sb.append(" ");

            for (Character c : word.toCharArray()) {
                if (!node.map.containsKey(c) || node.word != null) {
                    break;
                }
                node = node.map.get(c);
            }

            sb.append(node.word != null ? node.word : word);

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}
