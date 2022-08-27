/*
https://leetcode.com/problems/smallest-string-with-swaps/
 */

package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SmallestStringWithSwaps {
    private int[] root;
    private int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int size = s.length();
        initialize(size);

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            List<Integer> list = map.getOrDefault(root, new ArrayList<>());
            list.add(i);
            map.put(root, list);
        }

        char[] smallestString = new char[s.length()];

        for (List<Integer> indices : map.values()) {
            List<Character> characters = new ArrayList<>();

            for (Integer index : indices) {
                characters.add(s.charAt(index));
            }

            Collections.sort(characters);

            for (int i = 0; i < indices.size(); i++) {
                Integer index = indices.get(i);
                smallestString[index] = characters.get(i);
            }

        }

        return new String(smallestString);
    }

    private void initialize(int n) {
        root = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int value) {
        if (root[value] == value) {
            return value;
        }

        return find(root[value]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            root[rootA] = rootB;
        } else {
            root[rootB] = rootA;
            rank[rootA]++;
        }
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps m = new SmallestStringWithSwaps();

        List<List<Integer>> pairs1 = List.of(
                List.of(0, 3),
                List.of(1, 2)
        );

//        System.out.println(m.smallestStringWithSwaps("dcab", pairs1)); //bacd

        List<List<Integer>> pairs2 = List.of(
                List.of(3, 3),
                List.of(3, 0),
                List.of(5, 1),
                List.of(3, 1),
                List.of(3, 4),
                List.of(3, 5)
        );

        System.out.println(m.smallestStringWithSwaps("udyyek", pairs2)); //"deykuy"
    }
}
