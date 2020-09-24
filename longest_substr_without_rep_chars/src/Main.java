/*
Given a string s, find the length of the longest substring without repeating characters.
 */

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int lengthOfLongestSubstring(String s) {
        int position = 0;
        int leftPosition = 0;
        int max = 0;

        Map<Character, Integer> characterToPosition = new HashMap<>(26);

        while (position < s.length()) {
            char c = s.charAt(position);
            if (characterToPosition.containsKey(c)) {
                if (leftPosition <= characterToPosition.get(c)) {
                    if (max < position - leftPosition)
                        max = position - leftPosition;

                    leftPosition = characterToPosition.get(c) + 1;
                }

            }

            characterToPosition.put(c, position);
            position++;
        }

        if (max < position - leftPosition)
            max = position - leftPosition;

        return max;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "aab";
        String s5 = "dvdf";
        String s6 = "asjrgapa";
        String s7 = "";
        String s8 = " ";
        String s9 = "asjsarga";

        /*
        asjrgapa -> sjrgap
        asjargapa -> as|jsarga
         */

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
        System.out.println(lengthOfLongestSubstring(s5));
        System.out.println(lengthOfLongestSubstring(s6));
        System.out.println(lengthOfLongestSubstring(s7));
        System.out.println(lengthOfLongestSubstring(s8));
        System.out.println(lengthOfLongestSubstring(s9));
    }
}
