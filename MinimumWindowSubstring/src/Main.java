import java.util.HashMap;
import java.util.Map;

public class Main {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(t.length());
        Map<Character, Integer> referenceMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            map.put(c, 0);
        }

        int min = 100000;
        int max = -1;
        Map<Character, Integer> indexes = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) {
                    map.remove(c);
                } else {

                }
            }
        }

        return null;
    }
}
