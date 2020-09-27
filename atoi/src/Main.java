/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
    If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

 */

public class Main {
    public static int myAtoi(String str) {
        str = str.trim();

        if (str.isEmpty())
            return 0;

        int sign = 1;
        int i = 0;
        Long number = 0L;

        if (str.charAt(0) != '+' && str.charAt(0) != '-' && str.charAt(0) < 48 && str.charAt(0) > 57) {
            return 0;
        }

        if (str.charAt(0) == '-') {
            sign = -1;
            i = 1;
        }

        if (str.charAt(0) == '+') {
            i = 1;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 48 || c > 57) {
                break;
            }
            number = number * 10 + sign * (c - 48);

            if (number.compareTo((long) Integer.MIN_VALUE) < 0)
                return Integer.MIN_VALUE;

            if (number.compareTo((long) Integer.MAX_VALUE) > 0)
                return Integer.MAX_VALUE;
        }

        return number.intValue();
    }

    public static void main(String[] args) {
        String s1 = "92";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "+1";
        String s7 = "9223372036854775808";

        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
        System.out.println(myAtoi(s6));
        System.out.println(myAtoi(s7));
    }
}
