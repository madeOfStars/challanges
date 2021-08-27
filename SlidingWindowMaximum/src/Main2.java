/*
https://leetcode.com/problems/sliding-window-maximum/
 */
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o2[0] - o1[0] == 0)
                return o1[1] - o2[1];
            return o2[0] - o1[0];
        });


        for (int i = 0; i < k; i++) {
            int num = nums[i];
            queue.add(new int[]{num, i});
        }

        int index = 0;
        result[index] = queue.peek()[0];

        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == queue.peek()[0]) {
                queue.poll();
            }

            queue.add(new int[]{nums[i], i});

            while (!queue.isEmpty() && queue.peek()[1] < i - k)
                queue.poll();

            result[++index] = queue.peek()[0];
        }

        return result;
    }

    public static void main(String[] args) {
        Main2 m = new Main2();

        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(m.maxSlidingWindow(arr1, 3)));

        int[] arr2 = {1};
        System.out.println(Arrays.toString(m.maxSlidingWindow(arr2, 1)));

        int[] arr3 = {9, 11};
        System.out.println(Arrays.toString(m.maxSlidingWindow(arr3, 2)));

        int[] arr4 = {4, -2};
        System.out.println(Arrays.toString(m.maxSlidingWindow(arr4, 2)));

        int[] arr5 = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(Arrays.toString(m.maxSlidingWindow(arr5, 5)));

        int[] arr6 = {-7, -8, 7, 5, 7, 1, 6, 0};
        System.out.println(Arrays.toString(m.maxSlidingWindow(arr6, 4)));
    }
}
