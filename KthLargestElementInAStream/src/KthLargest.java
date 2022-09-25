/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */

import java.util.PriorityQueue;

public class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
        }

        while (heap.size() > k)
            heap.poll();
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k)
            heap.poll();
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargest m = new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println(m.add(3));
        System.out.println(m.add(5));
        System.out.println(m.add(10));
        System.out.println(m.add(9));
        System.out.println(m.add(4));
    }
}
