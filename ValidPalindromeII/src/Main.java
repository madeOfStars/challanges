/*
https://leetcode.com/problems/valid-palindrome-ii/
 */
public class Main {
    public boolean validPalindrome(String s) {
        if (s.length() == 1 || s.length() == 2)
            return true;

        for (int direction = 0; direction <= 1; direction++) {
            int count = 0;
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    count++;
                    if (direction == 0)
                        left++;
                    else
                        right--;

                    if (count >= 2)
                        break;
                } else {
                    left++;
                    right--;
                }
            }

            if (count <= 1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.validPalindrome("aba"));
        System.out.println(m.validPalindrome("abca"));
        System.out.println(m.validPalindrome("abc"));
        System.out.println(m.validPalindrome("azaabaaa"));
        System.out.println(m.validPalindrome("tebbem")); //false
    }
}
