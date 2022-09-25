/*
https://leetcode.com/problems/compare-version-numbers/
 */

public class Main {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int n = split1.length;
        int m = split2.length;
        int bound = Math.max(n, m);

        int i = 0;

        while (i < bound) {
            int first = i < n ? Integer.parseInt(split1[i]) : 0;
            int second = i < m ? Integer.parseInt(split2[i]) : 0;

            if (first < second) {
                return -1;
            }

            if (first > second)
                return 1;

            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.compareVersion("1.01", "1.001")); //0
        System.out.println(m.compareVersion("1.0", "1.0.0")); //0
        System.out.println(m.compareVersion("0.1", "1.1")); //-1
    }
}
