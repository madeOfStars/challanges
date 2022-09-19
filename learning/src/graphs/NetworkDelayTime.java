/*
https://leetcode.com/problems/network-delay-time/
 */

package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
    private record Pair(Integer left, Integer right) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int[] time : times) {
            adj.putIfAbsent(time[0], new ArrayList<>());
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.right));
        queue.add(new Pair(k, 0));
        dist[k] = 0;

        while (!queue.isEmpty()) {
            var polledNode = queue.poll();

            if (polledNode.right > dist[polledNode.left]) {
                continue;
            }

            if (!adj.containsKey(polledNode.left)) {
                continue;
            }

            for (var nextNode : adj.get(polledNode.left)) {

                var neighbor = nextNode.left;
                var time = nextNode.right;

                if (polledNode.right + time < dist[neighbor]) {
                    dist[neighbor] = polledNode.right + time;
                    queue.add(new Pair(neighbor, dist[neighbor]));
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dist[i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        NetworkDelayTime m = new NetworkDelayTime();

        int[][] times1 = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        System.out.println(m.networkDelayTime(times1, 4, 2)); //2

        int[][] times2 = {
                {1, 2, 1},
        };

        System.out.println(m.networkDelayTime(times2, 2, 1)); //1

        int[][] times3 = {
                {1, 2, 1},
        };

        System.out.println(m.networkDelayTime(times3, 2, 2)); //-1
    }
}
