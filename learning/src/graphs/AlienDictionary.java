/*
https://leetcode.com/problems/alien-dictionary/
 */

package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        final Map<Character, List<Character>> adj = new HashMap<>();
        final Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char character : word.toCharArray()) {
                inDegree.put(character, 0);
                adj.put(character, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currWord = words[i];

            if (prevWord.length() > currWord.length() && prevWord.startsWith(currWord)) {
                return "";
            }

            for (int j = 0; j < Math.min(prevWord.length(), currWord.length()); j++) {
                var prevChar = prevWord.charAt(j);
                var currChar = currWord.charAt(j);

                if (prevChar != currChar) {
                    adj.get(prevChar).add(currChar);
                    inDegree.put(currChar, inDegree.get(currChar) + 1);
                    break;
                }
            }
        }

        final Queue<Character> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> ce : inDegree.entrySet()) {
            if (ce.getValue() == 0) {
                queue.add(ce.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            var node = queue.poll();
            sb.append(node);

            if (adj.containsKey(node)) {
                for (Character linkedChar : adj.get(node)) {
                    var degree = inDegree.get(linkedChar);
                    degree--;
                    inDegree.put(linkedChar, degree);

                    if (degree == 0) {
                        queue.add(linkedChar);
                    }
                }
            }
        }

        if (sb.length() == inDegree.size()) {
            return sb.toString();
        }

        return "";
    }

    public static void main(String[] args) {
        AlienDictionary m = new AlienDictionary();

        final String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};

//        System.out.println(m.alienOrder(words1));

        final String[] words2 = {"ac", "ab", "zc", "zb"};

        System.out.println(m.alienOrder(words2));
    }
}
