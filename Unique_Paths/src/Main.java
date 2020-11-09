/*
https://leetcode.com/problems/unique-paths/
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int uniquePaths(int m, int n) {
        Map<String, Integer> locationToPath = new HashMap<>();
        return uniquePaths(locationToPath, m - 1, n - 1);
    }

    public static int uniquePaths(Map<String, Integer> locationToPath, int m, int n) {
        if (locationToPath.containsKey(m + "|" + n))
            return locationToPath.get(m + "|" + n);
        if (m < 0 || n < 0)
            return 0;
        else if (m == 0 && n == 0)
            return 1;
        else {
            int path = uniquePaths(locationToPath, m - 1, n) + uniquePaths(locationToPath, m, n - 1);
            locationToPath.put(m + "|" + n, path);
            return path;
        }
    }

    public static void main(String[] args) {
        int m1 = 3, n1 = 7;
        int m2 = 3, n2 = 2;
        int m3 = 7, n3 = 3;
        int m4 = 3, n4 = 3;
        int m5 = 51, n5 = 9;

        System.out.println(uniquePaths(m1, n1));
        System.out.println(uniquePaths(m2, n2));
        System.out.println(uniquePaths(m3, n3));
        System.out.println(uniquePaths(m4, n4));
        System.out.println(uniquePaths(m5, n5));
    }
}
