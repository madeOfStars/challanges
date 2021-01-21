/*
https://leetcode.com/problems/reverse-string/
 */
package recursion;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s.length > 0)
            helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int left, int right) {
        if (left >= right)
            return;

        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;

        helper(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

        rs.reverseString(s1);
        rs.reverseString(s2);

        System.out.println(s1);
        System.out.println(s2);
    }
}
