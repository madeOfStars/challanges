/*
https://leetcode.com/problems/sequential-digits/
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int step = 11;
        int lowStart = 12;
        int start = 12;

        int digit = 2;

        while (start <= high) {
            if (start >= low) {
                ans.add(start);
            }

            start += step;

            if (start % 10 == 0) {
                digit++;
                lowStart = lowStart * 10 + digit;
                start = lowStart;
                step = step * 10 + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

//        m.sequentialDigits(100, 1000);
//        m.sequentialDigits(100, 300);
        System.out.println(m.sequentialDigits(1000, 13000));
    }
}
