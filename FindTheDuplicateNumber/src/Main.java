/*
https://leetcode.com/problems/find-the-duplicate-number/
 */

public class Main {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) {
                return index;
            }

            nums[index] *= -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(m.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
