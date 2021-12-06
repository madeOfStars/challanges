public class MainRecursion {
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        return Math.max(helper(nums, index + 1), helper(nums, index + 2) + nums[index]);
    }

    public static void main(String[] args) {
        MainRecursion m = new MainRecursion();

        System.out.println(m.rob(new int[]{1, 2, 3, 1}));
        System.out.println(m.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
