import java.util.*;

public class Main {

    static Map<String, Long> cachedResults = new HashMap<>();

    public static long getWays(List<Integer> list, int length, int total) {
        if (length <= 0 && total >= 1)
            return 0;
        if (total == 0)
            return 1;
        if (total < 0)
            return 0;

        String key = length + "|" + total;

        if (!cachedResults.containsKey(key)) {
            cachedResults.put(key, getWays(list, length - 1, total) + getWays(list, length, total - list.get(length - 1)));
        }

        return cachedResults.get(key);
    }

    public static void main(String[] args) {
        int n = 85;
        List<Integer> list = Arrays.asList(50, 10, 17, 21, 8, 3, 12, 41, 9, 13, 43, 37, 49, 19, 23, 28, 45, 46, 29, 16, 34, 25, 2, 22, 1);
        System.out.println(getWays(list, list.size(), n));
    }
}
