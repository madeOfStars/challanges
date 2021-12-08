public class Main {
    public int maxProduct(int[] nums) {
        int prod = nums[0] < 0 ? -100001 : nums[0];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                prod = 1;
        }

        return 0;
    }
}
