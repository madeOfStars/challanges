/*
https://leetcode.com/problems/group-anagrams/
 */
import java.util.*;

public class Main {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortedString = new String(chars);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }

            map.get(sortedString).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Main m = new Main();

        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(m.groupAnagrams(strs1));
    }
}
