/*
Alex works at a clothing store.
There is a large pile of socks that must be paired by color for sale.
Given an array of integers representing the color of each sock,
determine how many pairs of socks with matching colors there are.
 */

import java.util.Arrays;

public class Main {
    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        int counter = 1;
        int pairs = 0;

        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == ar[i - 1]) {
                counter++;
            } else {
                pairs += counter /2;
                counter = 1;
            }
        }
        return counter > 1 ? pairs + counter / 2 : pairs;
    }

    public static void main(String[] args) {
        int[] ar1 = new int[]{1, 2, 1, 2, 1, 3, 2};
        int[] ar2 = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        int[] ar3 = new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
        int[] ar4 = new int[]{6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5};

        System.out.println(sockMerchant(7, ar1));
        System.out.println(sockMerchant(9, ar2));
        System.out.println(sockMerchant(10, ar3));
        System.out.println(sockMerchant(10, ar4));
    }
}
