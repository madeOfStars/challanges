/*
https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 */

package graphs;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    private int[] root;
    private int[] rank;
    private int count;

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt((int[] log) -> log[0]));

        initialize(n);

        for (int[] log : logs) {
            union(log[1], log[2]);

            if (count == 1) {
                return log[0];
            }
        }

        return -1;
    }

    private void initialize(int n) {
        root = new int[n];
        rank = new int[n];
        count = n;

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

        count--;
    }

    public static void main(String[] args) {
        TheEarliestMomentWhenEveryoneBecomeFriends m = new TheEarliestMomentWhenEveryoneBecomeFriends();

        int[][] logs1 = new int[][]{
                {20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}
        };

        System.out.println(m.earliestAcq(logs1, 6)); //20190301

        int[][] logs2 = new int[][]{
                {0, 2, 0},
                {1, 0, 1},
                {3, 0, 3},
                {4, 1, 2},
                {7, 3, 1}
        };

        System.out.println(m.earliestAcq(logs2, 4)); //3

        int[][] logs3 = new int[][]{
                {9, 3, 0},
                {0, 2, 1},
                {8, 0, 1},
                {1, 3, 2},
                {2, 2, 0},
                {3, 3, 1}
        };

        System.out.println(m.earliestAcq(logs3, 4)); //2
    }
}
