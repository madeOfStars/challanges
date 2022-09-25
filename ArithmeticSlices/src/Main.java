public class Main {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 1)
            return 0;

        int[] dp = new int[nums.length];

        int count = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
