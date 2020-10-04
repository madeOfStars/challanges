/*
Lilah has a string, s,
of lowercase English letters that she repeated infinitely many times.

Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.

For example, if the string s = 'abcac'
and n = 10, the substring we consider is abcacabcac, the first 10 characters of her infinite string.
There are 4 occurrences of a in the substring.
 */

public class Main {
    static long repeatedString(String s, long n) {
        int occurrencesInTheBlock = findOccurrences(s);
        int blockLength = s.length();

        return occurrencesInTheBlock * (n / blockLength) + findOccurrences(s.substring(0, (int) (n % blockLength)));
    }

    private static int findOccurrences(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
    }
}
