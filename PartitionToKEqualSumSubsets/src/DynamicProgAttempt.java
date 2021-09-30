import java.util.Arrays;

public class DynamicProgAttempt {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        if (sum % k != 0)
            return false;

        int wantedSum = sum / k;

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == wantedSum) {
                dp[i][i] = 1;
            } else {
                dp[i][i] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            int colSum = nums[j];
            for (int i = j - 1; i >= 0; i--) {
                colSum += nums[i];

                if (nums[i] == wantedSum || nums[i] + nums[j] == wantedSum || colSum % wantedSum == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j - 1], dp[i + 1][j]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][n - 1] == k;
    }

    public static void main(String[] args) {
        DynamicProgAttempt m = new DynamicProgAttempt();

        /*System.out.println(m.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4)); // true
        System.out.println(m.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3)); //false
        System.out.println(m.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4)); // false*/
        System.out.println(m.canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 4)); // true
    }
}
