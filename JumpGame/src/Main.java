/*
https://leetcode.com/problems/jump-game/
 */
public class Main {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;

        int reach = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            reach = Math.max(reach, i + nums[i]);

            if (reach <= i)
                return false;

            if (reach >= nums.length - 1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(m.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(m.canJump(new int[]{0}));
        System.out.println(m.canJump(new int[]{2, 0, 0}));
        System.out.println(m.canJump(new int[]{0, 2, 3}));
    }
}
