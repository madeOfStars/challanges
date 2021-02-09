/*
https://leetcode.com/problems/powx-n/
 */
package recursion;

public class PowXN {
    public double myPow(double x, int n) {
        double a;
        if (n == 0)
            return 1;
        else if (n < 0)
            if (n == Integer.MIN_VALUE)
                return myPow(1 / x, -(n + 1)) * 1 / x;
            else
                return myPow(1 / x, -n);
        else {
            a = myPow(x, n / 2);
            if (n % 2 == 0)
                return a * a;
            else
                return x * a * a;
        }
    }

    public static void main(String[] args) {
        PowXN p = new PowXN();

        System.out.println(p.myPow(2.00000, 10));
        System.out.println(p.myPow(2.00000, -2));
        System.out.println(p.myPow(0.00001, 2147483647));
        System.out.println(p.myPow(1.00000, -2147483648));
    }
}
