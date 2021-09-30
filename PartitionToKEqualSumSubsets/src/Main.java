/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
import java.util.*;

public class Main {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        if (sum % k != 0)
            return false;

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];
        return helper(nums, 0, sum / k, 0, k, visited);
    }

    private boolean helper(int[] nums, int currSum, int sumPerBucket, int start, int k, boolean[] visited) {
        if (k == 0)
            return true;

        if (currSum == sumPerBucket)
            return helper(nums, 0, sumPerBucket, 0, k - 1, visited);

        for (int i = start; i < nums.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            if (helper(nums, currSum + nums[i], sumPerBucket, i + 1, k, visited))
                return true;
            visited[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        //System.out.println(m.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4)); // true
        //System.out.println(m.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3)); //false
        //System.out.println(m.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4)); // false
        System.out.println(m.canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 4)); // true
    }
}
