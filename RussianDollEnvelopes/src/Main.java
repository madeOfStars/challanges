/*
https://leetcode.com/problems/russian-doll-envelopes/
 */
import java.util.Arrays;

public class Main {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1)
            return 1;

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o1[0] - o2[0];
        });

        int[] heights = new int[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            int[] envelope = envelopes[i];
            heights[i] = envelope[1];
        }

        int[] dp = new int[heights.length];
        int len = 0;
        for (int height : heights) {
            int i = Arrays.binarySearch(dp, 0, len, height);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = height;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] env1 = new int[][] {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        System.out.println(m.maxEnvelopes(env1));
    }
}
