/*
https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */

package graphs;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst)
            return 0;

        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = Integer.MAX_VALUE;
            curr[i] = Integer.MAX_VALUE;
        }

        prev[src] = 0;

        for (int i = 1; i < k + 2; i++) {
            curr[src] = 0;

            for (int[] flight : flights) {
                final var start = flight[0];
                final var finish = flight[1];
                final var dist = flight[2];

                if (prev[start] < Integer.MAX_VALUE) {
                    curr[finish] = Math.min(curr[finish], prev[start] + dist);
                }
            }

            prev = curr.clone();
        }

        return curr[dst] == Integer.MAX_VALUE ? -1 : curr[dst];
    }
}
