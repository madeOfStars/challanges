/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
import java.util.PriorityQueue;

public class Main {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int num : nums) {
            queue.add(num);

            if (queue.size() > k)
                queue.poll();
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
