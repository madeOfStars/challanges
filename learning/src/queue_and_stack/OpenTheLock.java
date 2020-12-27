package queue_and_stack;

import java.util.*;

public class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<Integer> visited = new HashSet<>();
        Arrays.stream(deadends).forEach(el -> visited.add(Integer.parseInt(el)));

        int start = 0;

        if (visited.contains(start))
            return -1;

        List<Integer> incrementals = List.of(1000, 100, 10, 1, -1000, -100, -10, -1);
        Queue<Integer> nodes = new PriorityQueue<>();
        nodes.add(0);
        visited.add(0);

        int step = 0;

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            step++;

            for (int i = 0; i < size; i++) {
                Integer peekedNode = nodes.peek();

                if (peekedNode == Integer.parseInt(target))
                    return step;

                for (Integer incremental : incrementals) {
                    int nextNode = (peekedNode + incremental) % 10000;
                    if (!visited.contains(nextNode)) {
                        visited.add(nextNode);
                        nodes.add(nextNode);
                    }
                }
                nodes.poll();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] deadends1 = new String[] {"0201","0101","0102","1212","2002"};
        String target1 = "0202";

        String[] deadends2 = new String[] {"8888"};
        String target2 = "0009";

        String[] deadends3 = new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";

        System.out.println(openLock(deadends3, target3));
    }
}
