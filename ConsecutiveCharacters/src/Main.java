/*
https://leetcode.com/problems/consecutive-characters/
 */

public class Main {
    public int maxPower(String s) {
        char prevChar = s.charAt(0);
        int count = 1;
        int max = 1;

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == prevChar) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }

            prevChar = currChar;
        }

        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.maxPower("leetcode"));
        System.out.println(m.maxPower("abbcccddddeeeeedcba"));
        System.out.println(m.maxPower("tourist"));
    }
}
