/*
https://leetcode.com/problems/number-of-1-bits/submissions/
 */
public class Main {
    public int hammingWeight(int n) {
        int ans = 0;

        while (n != 0) {
            ans++;
            n &= n - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.hammingWeight(00000000000000000000000000001011));
    }
}
