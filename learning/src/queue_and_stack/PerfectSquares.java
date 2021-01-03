/*
https://leetcode.com/problems/perfect-squares/
 */
package queue_and_stack;

import java.util.*;

public class PerfectSquares {
    public static int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited.add(n);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Integer polledNode = queue.poll();
                if (polledNode == 0)
                    return count;

                for (int square : squares) {
                    int nextNode = polledNode - square;
                    if (nextNode >= 0 && !visited.contains(nextNode)) {
                        queue.add(nextNode);
                        visited.add(nextNode);
                    }
                }
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(43));
    }
}
