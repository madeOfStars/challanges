/*
https://leetcode.com/problems/house-robber/
 */
public class MainDynamicProg {
    public int rob(int[] nums) {
        int[] ans = new int[nums.length + 1];

        if (nums.length == 0)
            return 0;

        ans[0] = 0;
        ans[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i - 1]);
        }

        return ans[nums.length];
    }

    public static void main(String[] args) {
        MainDynamicProg m = new MainDynamicProg();

        System.out.println(m.rob(new int[]{1, 2, 3, 1}));
        System.out.println(m.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
