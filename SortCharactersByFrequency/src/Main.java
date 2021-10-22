/*
https://leetcode.com/problems/sort-characters-by-frequency/
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = -1;
        for (char c : s.toCharArray()) {
            int freq = map.getOrDefault(c, 0);
            freq++;
            map.put(c, freq);
            max = Math.max(max, freq);
        }

        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            list.add(new ArrayList<>());
        }

        for (char key : map.keySet()) {
            Integer freq = map.get(key);
            List<Character> tmpList = list.get(freq);
            for (int i = 0; i < freq; i++) {
                tmpList.add(key);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = max; i > 0; i--) {
            for (Character c : list.get(i)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.frequencySort("tree"));
    }
}
