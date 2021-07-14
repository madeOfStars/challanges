/*
https://leetcode.com/problems/isomorphic-strings/
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            } else if (!Objects.equals(map1.get(s.charAt(i)), t.charAt(i)) && !Objects.equals(map2.get(t.charAt(i)), s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.isIsomorphic("egg", "add"));
        System.out.println(m.isIsomorphic("foo", "bar"));
        System.out.println(m.isIsomorphic("paper", "title"));
        System.out.println(m.isIsomorphic("badc", "baba"));
    }
}
