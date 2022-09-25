/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/submissions/
 */

import java.util.HashMap;
import java.util.Map;

public class MainAttempt2 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : time) {
            if (t % 60 == 0) {
                count += map.getOrDefault(0, 0);
            } else {
                count += map.getOrDefault(60 - t % 60, 0);
            }

            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        MainAttempt2 m = new MainAttempt2();

        int[] time = new int[]{30, 20, 150, 100, 40};
        System.out.println(m.numPairsDivisibleBy60(time));

        int[] time1 = new int[]{60, 60, 80};
        System.out.println(m.numPairsDivisibleBy60(time1));
    }
}
