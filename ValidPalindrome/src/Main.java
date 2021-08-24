/*
https://leetcode.com/problems/valid-palindrome/
 */
public class Main {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append((char)(c + (c < 97 ? 32 : 0)));
            }
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        String formattedString = sb.toString();

        int left = 0;
        int right = formattedString.length() - 1;

        while (left < right) {
            if (formattedString.charAt(left) != formattedString.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(m.isPalindrome("race a car"));
        System.out.println(m.isPalindrome("0P"));
    }
}
