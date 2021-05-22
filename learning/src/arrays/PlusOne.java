/*
https://leetcode.com/problems/plus-one/
 */
package arrays;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int lastDigit = digits[index];

        lastDigit += 1;

        if (lastDigit < 10) {
            digits[index] = lastDigit;
            return digits;
        }

        if (lastDigit == 10 && digits.length == 1)
            return new int[]{1, 0};

        while (lastDigit >= 10 && index > 0) {
            digits[index] = lastDigit - 10;
            index--;
            digits[index] = digits[index] + 1;
            lastDigit = digits[index];
        }

        if (digits[0] == 10) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            result[1] = 0;

            for (int i = 1; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }

            return result;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();

        int[] digits1 = new int[]{6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3};
        int[] digits2 = new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        int[] digits3 = new int[]{9};
        int[] digits4 = new int[]{9, 9};

        System.out.println(Arrays.toString(po.plusOne(digits3)));
        System.out.println(Arrays.toString(po.plusOne(digits4)));
    }
}
