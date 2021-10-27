/*
https://leetcode.com/problems/sort-colors/
 */
import java.util.Arrays;

public class Main {
    public void sortColors(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int r = nums[i];
                nums[i] = nums[index];
                nums[index++] = r;
            }
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                int r = nums[i];
                nums[i] = nums[index];
                nums[index++] = r;
            }
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 2) {
                int r = nums[i];
                nums[i] = nums[index];
                nums[index++] = r;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = new int[]{2, 0, 2, 1, 1, 0};
        m.sortColors(nums1);

        System.out.println(Arrays.toString(nums1));
    }
}
