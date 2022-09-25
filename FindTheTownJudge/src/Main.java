/*
https://leetcode.com/problems/find-the-town-judge/
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int el = 1;
        int count = 0;

        for (int i = 0; i < trust.length; i++) {
            count = map.getOrDefault(trust[i][1], 0);
            count++;

            if (count >= max) {
                el = trust[i][1];
                max = count;
            }

            map.put(trust[i][1], count);
        }

        if (max != n - 1)
            return -1;

        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] == el)
                return -1;
        }

        return el;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] trust = new int[][]{
                {1, 2},
                {1, 3},
                {2, 1},
                {2, 3},
                {1, 4},
                {4, 3},
                {4, 1}
        };

        System.out.println(m.findJudge(4, trust));
    }
}

