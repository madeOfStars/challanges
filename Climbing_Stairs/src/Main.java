/*
https://leetcode.com/problems/climbing-stairs/
 */

public class Main {
    public static int climbStairs(int n) {
        int firstStep = 1;
        int secondStep = 2;
        int totalSteps = 0;

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            for (int i = 3; i <= n; i++) {
                totalSteps = firstStep + secondStep;
                firstStep = secondStep;
                secondStep = totalSteps;
            }
        }

        return totalSteps;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int n3 = 5;

        System.out.println(climbStairs(n1));
        System.out.println(climbStairs(n2));
        System.out.println(climbStairs(n3));
    }
}
