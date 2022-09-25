/*
https://leetcode.com/problems/number-complement/
 */

public class Main {
    public int findComplement(int num) {
        int length = (int) ((Math.log(num) / Math.log(2)) + 1);
        int bitmask = (1 << length) - 1;

        return bitmask ^ num;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.findComplement(7));
    }
}
