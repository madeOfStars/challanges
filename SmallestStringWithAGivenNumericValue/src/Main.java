/*
https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */

import java.util.Arrays;

public class Main {
    public String getSmallestString(int n, int k) {
        final int[] data = new int[n];
        int sum = n;

        Arrays.fill(data, 1);

        int index = n - 1;

        while (k - sum > 0) {
            int containerValue = k - sum + 1;
            containerValue = containerValue > 26 ? 26 : (k - sum + 1);
            sum = sum - 1 + 26;
            data[index--] = containerValue;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append((char)(data[i] - 1 + 'a'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.getSmallestString(3, 27));
        System.out.println(m.getSmallestString(5, 73));
    }
}
