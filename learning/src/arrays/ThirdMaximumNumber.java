/*
https://leetcode.com/problems/third-maximum-number/
 */
package arrays;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        int count = 0;

        for (int num : nums) {
            if ((max1 != null && num == max1) || (max2 != null && num == max2) || (max3 != null && num == max3))
                continue;

            count++;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }

        if (count < 3)
            max3 = max1;

        return max3;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber tmn = new ThirdMaximumNumber();

        int[] nums1 = new int[]{1, 2, -2147483648};
        int[] nums2 = new int[]{2, 2, 3, 1};

        System.out.println(tmn.thirdMax(nums1));
        System.out.println(tmn.thirdMax(nums2));
    }
}
