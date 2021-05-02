/*
https://leetcode.com/problems/max-consecutive-ones/
 */
package arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1)
                count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        max = Math.max(max, count);

        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes mo = new MaxConsecutiveOnes();

        int[] nums = new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(mo.findMaxConsecutiveOnes(nums));
    }
}
