/*
https://leetcode.com/problems/flip-string-to-monotone-increasing/
 */

package amz;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int length = ratings.length;

        if (length == 1)
            return 1;

        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        Candy m = new Candy();
        System.out.println(m.candy(new int[]{1, 2, 3})); //6
        System.out.println(m.candy(new int[]{3, 2, 1})); //6
        System.out.println(m.candy(new int[]{1, 0, 2})); //5
        System.out.println(m.candy(new int[]{1, 2, 2})); //4
        System.out.println(m.candy(new int[]{1, 3, 4, 5, 2})); //11

    }
}
