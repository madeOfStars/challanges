/*
https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
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

    private final TrieNode trieNode;

    public WordDictionary() {
        trieNode = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = trieNode;

        for (char c : word.toCharArray()) {
            if (!curr.links.containsKey(c)) {
                curr.put(c, new TrieNode());
            }

            curr = curr.get(c);
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return helper(trieNode, word);
    }

    private boolean helper(TrieNode node, String word) {
        TrieNode curr = node;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!curr.links.containsKey(c)) {
                if (c == '.') {
                    for (Character character : curr.links.keySet()) {
                        if (helper(curr.get(character), word.substring(i + 1)))
                            return true;
                    }
                }
                return false;
            } else {
                curr = curr.get(c);
            }
        }

        return curr.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        /*wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True*/


        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}
