/*
https://leetcode.com/problems/shuffle-an-array/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    private final int[] ORIGINAL_ARRAY;
    private final int[] nums;

    private final List<Integer> list = new ArrayList<>();

    public Solution(int[] nums) {
        ORIGINAL_ARRAY = nums.clone();
        this.nums = nums;
        Arrays.stream(nums).forEach(list::add);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return ORIGINAL_ARRAY;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {-9, 10, 100, 20};
//        int[] nums = {-6, 10, 184};

        Solution obj = new Solution(nums);
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}
