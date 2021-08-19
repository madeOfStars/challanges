/*
https://leetcode.com/problems/word-ladder/
 */
import java.util.*;

public class Main {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int result = 1;

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String polledWord = queue.poll();

                if (polledWord.equals(endWord))
                    return result;

                for (int letter = 0; letter < beginWord.length(); letter++) {
                    for (char character = 'a'; character <= 'z'; character++) {
                        String newWord = sb.append(polledWord, 0, letter)
                                .append(character)
                                .append(polledWord.substring(letter + 1))
                                .toString();

                        if (!visited.contains(newWord) && wordSet.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                        sb.setLength(0);
                    }
                }
            }
            result++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(m.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println(m.ladderLength("hot", "dog", Arrays.asList("hot", "dog", "dot")));
    }
}
