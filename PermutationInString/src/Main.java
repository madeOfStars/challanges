/*
https://leetcode.com/problems/permutation-in-string/
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        Map<Character, Integer> origMap = new HashMap<>(s1Length);

        for (char c : s1.toCharArray()) {
            origMap.put(c, origMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if (i >= s1Length) {
                char firstChar = s2.charAt(i - s1Length);
                map.put(firstChar, map.get(firstChar) - 1);

                if (map.get(firstChar) == 0)
                    map.remove(firstChar);
            }

            if (origMap.equals(map))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.checkInclusion("ab", "eidbaooo"));
        System.out.println(m.checkInclusion("ab", "eidoaooo"));
    }
}
