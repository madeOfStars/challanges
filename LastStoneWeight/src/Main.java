/*
https://leetcode.com/problems/last-stone-weight/
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        if (stones.length == 1)
            return stones[0];

        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();

            int diff = Math.abs(first - second);

            if (diff != 0) {
                heap.add(diff);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(m.lastStoneWeight(new int[]{2, 2}));
    }
}
