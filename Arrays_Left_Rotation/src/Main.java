/*
https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
 */

import java.util.Arrays;

public class Main {
    static int[] rotLeft(int[] a, int d) {
        int []result = new int[a.length];
        System.arraycopy(a, d, result, 0, a.length - d);
        System.arraycopy(a, 0, result, a.length - d, d);

        return result;
    }

    public static void main(String[] args) {
        int []a = new int[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(rotLeft(a, 1)));
        System.out.println(Arrays.toString(rotLeft(a, 2)));
        System.out.println(Arrays.toString(rotLeft(a, 3)));
        System.out.println(Arrays.toString(rotLeft(a, 4)));
        System.out.println(Arrays.toString(rotLeft(a, 5)));
    }
}
