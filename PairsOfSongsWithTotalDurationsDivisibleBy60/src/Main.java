/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/submissions/
 */
import java.util.HashMap;
import java.util.Map;

public class Main {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length < 2)
            return 0;

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int t : time) {
            if (t % 60 == 0)
                ans += map.getOrDefault(0, 0);
            else
                ans += map.getOrDefault(60 - t % 60, 0);

            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(m.numPairsDivisibleBy60(new int[]{60, 60, 60}));
        System.out.println(m.numPairsDivisibleBy60(new int[]{60, 60, 60, 40, 20}));
    }
}
