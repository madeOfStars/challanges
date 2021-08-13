/*
https://leetcode.com/problems/consecutive-numbers-sum/
 */
public class Main {
    public int consecutiveNumbersSum(int n) {
        int result = 0;

        for (int i = 2; (1 + i) * i / 2 <= n; i++) {
            if ((n - (1 + i) * i / 2) % i == 0)
                result++;
        }

        return result + 1;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.consecutiveNumbersSum(5));
        System.out.println(m.consecutiveNumbersSum(9));
        System.out.println(m.consecutiveNumbersSum(15));
        System.out.println(m.consecutiveNumbersSum(1499581));
    }
}
