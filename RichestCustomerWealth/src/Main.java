/*
https://leetcode.com/problems/richest-customer-wealth/
 */

public class Main {
    public int maximumWealth(int[][] accounts) {
        int max = -1;

        for (int[] account : accounts) {
            int sum = 0;

            for (int i : account) {
                sum += i;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
