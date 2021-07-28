/*
https://leetcode.com/problems/beautiful-array/
 */
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public int[] beautifulArray(int n) {
        int cur = n;
        int bits = 0;

        while (cur != 0) {
            cur >>= 1;
            bits++;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = 0;
            int b = bits - 1;
            cur = i + 1;

            while (cur != 0) {
                if ((cur & 1) == 1)
                    x += (1 << b);
                cur >>= 1;
                b--;
            }

            map.put(x, i + 1);
        }

        int[] result = new int[n];
        int index = 0;

        for (Integer value : map.values()) {
            result[index] = value;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(Arrays.toString(m.beautifulArray(5)));
    }
}
