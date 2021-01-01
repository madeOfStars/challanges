/*
https://leetcode.com/problems/open-the-lock/
 */
package queue_and_stack;

import java.util.*;

public class OpenTheLock2 {
    public static int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> nodes = new LinkedList<>();

        if (visited.contains("0000"))
            return -1;

        nodes.add("0000");
        visited.add("0000");

        int count = 0;

        while (!nodes.isEmpty()) {

            int size = nodes.size();

            while (size-- > 0) {
                String polledNode = nodes.remove();

                if (polledNode.equals(target))
                    return count;

                for (int i = 0; i < 4; ++i) {
                    char c = polledNode.charAt(i) == '9' ? '0' : (char) (polledNode.charAt(i) + 1);
                    addNodeIfPossible(c, polledNode, i, visited, nodes);
                    c = polledNode.charAt(i) == '0' ? '9' : (char) (polledNode.charAt(i) - 1);
                    addNodeIfPossible(c, polledNode, i, visited, nodes);
                }
            }
            count++;
        }
        return -1;
    }

    private static void addNodeIfPossible(char c, String polledNode, int i, Set<String> visited, Queue<String> nodes) {
        String nextNode = polledNode.substring(0, i) + c + polledNode.substring(i + 1);
        if (!visited.contains(nextNode)) {
            visited.add(nextNode);
            nodes.add(nextNode);
        }
    }

    public static void main(String[] args) {
        String[] deadends1 = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target1 = "0202";

        String[] deadends2 = new String[]{"8888"};
        String target2 = "0009";

        String[] deadends3 = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target3 = "8888";

        System.out.println(openLock(deadends1, target1));
    }
}
