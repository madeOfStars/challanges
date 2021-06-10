/*
https://leetcode.com/problems/longest-common-prefix/
 */
package arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strs.length; i++) {

            if (common.equals(strs[i]))
                continue;

            int j = 0;
            while (j < common.length() && j < strs[i].length() && common.charAt(j) == strs[i].charAt(j)) {
                sb.append(common.charAt(j));
                j++;
            }

            if (j == 0) {
                return "";
            }

            common = sb.toString();
            sb.setLength(0);
        }

        return common;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();

        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};

        System.out.println(l.longestCommonPrefix(strs1));
        System.out.println(l.longestCommonPrefix(strs2));
    }

}
