/*
https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class Main {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;

        int[] values = new int[n + 1];
        values[0] = 0;
        values[1] = 1;
        values[2] = 1;

        for (int i = 3; i <= n; i++) {
            values[i] = values[i - 1] + values[i - 2] + values[i - 3];
        }

        return values[n];
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.tribonacci(4));
        System.out.println(m.tribonacci(25));
    }
}
