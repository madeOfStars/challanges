/*
https://leetcode.com/problems/group-anagrams/
 */

package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            var charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            var list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        List<List<String>> ans = new ArrayList<>(map.size());

        ans.addAll(map.values());

        return ans;
    }

    public static void main(String[] args) {
        GroupAnagrams m = new GroupAnagrams();
        System.out.println(m.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
