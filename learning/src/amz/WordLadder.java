/*
https://leetcode.com/problems/word-ladder/
 */

package amz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String polledString = queue.poll();

                if (polledString.equals(endWord)) {
                    return count;
                }

                for (int index = 0; index < polledString.length(); index++) {
                    char[] mutableLetters = polledString.toCharArray();
                    for (char digit = 'a'; digit <= 'z'; digit++) {
                        mutableLetters[index] = digit;

                        String currentWord = new String(mutableLetters);

                        if (!visited.contains(currentWord) && set.contains(currentWord)) {
                            queue.add(currentWord);
                            visited.add(currentWord);
                        }
                    }
                }
            }

            count++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder m = new WordLadder();

        System.out.println(m.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"))); //5
        System.out.println(m.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log"))); //0
        System.out.println(m.ladderLength("a", "c", List.of("a", "b", "c"))); //2
    }
}
