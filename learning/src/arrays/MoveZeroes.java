/*
https://leetcode.com/problems/move-zeroes/
 */
package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                queue.add(i);
            else {
                if (!queue.isEmpty()) {
                    int r = queue.poll();
                    nums[r] = nums[i];
                    nums[i] = 0;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();

        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0, 0, 0, 3, 12, 0, 0, 2, 4};
        mz.moveZeroes(nums2);

        System.out.println(Arrays.toString(nums2));
    }
}
