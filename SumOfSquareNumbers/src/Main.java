/*
https://leetcode.com/problems/sum-of-square-numbers/
 */
public class Main {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.ceil(Math.sqrt(c));

        while (left <= right) {
            final int sum = left * left + right * right;
            if (sum == c)
                return true;
            else if (sum < c)
                left++;
            else
                right--;
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.judgeSquareSum(5));
        System.out.println(m.judgeSquareSum(3));
        System.out.println(m.judgeSquareSum(4));
        System.out.println(m.judgeSquareSum(2));
        System.out.println(m.judgeSquareSum(1));
        System.out.println(m.judgeSquareSum(Integer.MAX_VALUE));
    }
}
