/*
https://leetcode.com/problems/open-the-lock/
 */
package queue_and_stack;

import java.util.*;

public class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<Integer> visited = new HashSet<>();
        Arrays.stream(deadends).forEach(el -> visited.add(Integer.parseInt(el)));

        int start = 0;

        if (visited.contains(start))
            return -1;

        int[] incrementals = new int[8];

        int pow = 3;

        for (int i = 0; i < target.length(); i++) {
            int value = Character.getNumericValue(target.charAt(i));

            if (value < 5) {
                incrementals[i] = (int) Math.pow(10, pow);
                incrementals[i + 4] = (int) (-1 * Math.pow(10, pow));
            } else {
                incrementals[i] = (int) (-1 * Math.pow(10, pow));
                incrementals[i + 4] = (int) Math.pow(10, pow);
            }

            pow--;
        }

        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(start);
        visited.add(start);

        int step = 0;

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            step++;

            for (int i = 0; i < size; i++) {
                Integer polledNode = nodes.poll();

                System.out.print(polledNode + " <- ");

                if (polledNode == Integer.parseInt(target)) {
                    System.out.println();
                    return step - 1;
                }

                for (Integer incremental : incrementals) {
                    int nextNode = (polledNode + incremental) % 10000;

                    if (nextNode < 0)
                        nextNode = Math.abs(incremental * 10) + nextNode;

                    if (!visited.contains(nextNode)) {
                        visited.add(nextNode);
                        nodes.add(nextNode);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] deadends1 = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target1 = "0202";

        String[] deadends2 = new String[]{"8888"};
        String target2 = "7125";

        String[] deadends3 = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target3 = "8888";

        System.out.println(openLock(deadends1, target1));
    }
}
