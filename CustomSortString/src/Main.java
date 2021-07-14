/*
https://leetcode.com/problems/custom-sort-string/
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public String customSortString(String order, String str) {
        Map<Character, StringBuilder> map = new LinkedHashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), new StringBuilder());
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (map.containsKey(c))
                map.get(c).append(c);
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                map.put(c, sb);
            }
        }

        StringBuilder sb = new StringBuilder();
        map.forEach((c, stringBuilder) -> sb.append(stringBuilder.toString()));

        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.customSortString("cba", "abcd"));
    }
}
