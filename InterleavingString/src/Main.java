/*
https://leetcode.com/problems/interleaving-string/
 */
public class Main {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
            return true;

        if (s1.length() + s2.length() != s3.length())
            return false;

        return isInterleave(s1, s2, s3, s1.length() - 1, s2.length() - 1, s3.length() - 1);
    }

    private boolean isInterleave(String s1, String s2, String s3, int l, int r, int k) {
        if (l == -1 && r == -1 && k == -1)
            return true;

        if (l < 0 && k != r)
            return false;

        if (r < 0 && k != l)
            return false;

        if (l >= 0 && r >= 0 && s1.charAt(l) != s3.charAt(k) && s2.charAt(r) != s3.charAt(k))
            return false;

        if (l >= 0 && r >= 0 && s1.charAt(l) == s3.charAt(k) && s2.charAt(r) == s3.charAt(k))
            return isInterleave(s1, s2, s3, l - 1, r, k - 1) || isInterleave(s1, s2, s3, l, r - 1, k - 1);

        if (l >= 0 && s1.charAt(l) == s3.charAt(k)) {
            return isInterleave(s1, s2, s3, l - 1, r, k - 1);
        }

        if (r >= 0 && s2.charAt(r) == s3.charAt(k)) {
            return isInterleave(s1, s2, s3, l, r - 1, k - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(m.isInterleave(s1, s2, s3));

        String s11 = "aabcc";
        String s21 = "dbbca";
        String s31 = "aadbbbaccc";

        System.out.println(m.isInterleave(s11, s21, s31));

        String s12 = "a";
        String s22 = "b";
        String s32 = "a";

        System.out.println(m.isInterleave(s12, s22, s32));

        String s13 = "a";
        String s23 = "";
        String s33 = "c";

        System.out.println(m.isInterleave(s13, s23, s33));
    }
}
