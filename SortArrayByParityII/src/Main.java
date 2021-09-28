/*
https://leetcode.com/problems/sort-array-by-parity-ii/
 */
import java.util.Arrays;

public class Main {
    public int[] sortArrayByParityII(int[] nums) {
        int indexEven = 0;
        int indexOdd = 1;

        while (indexEven < nums.length && indexOdd < nums.length){
            if (nums[indexEven] % 2 == 0) {
                indexEven += 2;
            } else {
                int r = nums[indexEven];
                nums[indexEven] = nums[indexOdd];
                nums[indexOdd] = r;
                indexOdd += 2;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(Arrays.toString(m.sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(m.sortArrayByParityII(new int[]{5, 7, 4, 2})));
        System.out.println(Arrays.toString(m.sortArrayByParityII(new int[]{2, 3})));
        System.out.println(Arrays.toString(m.sortArrayByParityII(new int[]{3, 4})));
        System.out.println(Arrays.toString(m.sortArrayByParityII(new int[]{4,1,2,1})));
    }
}
