/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 */

import java.util.*;

public class Main {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int row = 0;
        int direction = 1;
        int capacity = Math.min(numRows, s.length());
        List<StringBuilder> strings = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++)
            strings.add(new StringBuilder());


        for (int i = 0; i < s.length(); i++) {
            strings.set(row, strings.get(row).append(s.charAt(i)));

            row += direction;

            if (row == numRows - 1) {
                direction = -1;
            }

            if (row == 0) {
                direction = 1;
            }

        }

        StringBuilder sb = new StringBuilder();

        for (StringBuilder stringBuilder : strings) {
            sb.append(stringBuilder.toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        String s2 = "AB";

        System.out.println(convert(s2, 1));

        /*
        PAYPALISHIRING -> 14

        P   A   H   N
        A P L S I I G
        Y   I   R

        PAHNAPLSIIGYIR

        1   5   9   3
        2 4 6 8 0 2 4
        3   7   1

        1   2   3   4   5   6   7   8   9   10  11  12  13 14
        1   5   9  13   2   4   6   8  10   12  14   3   7  1


        1     7    3
        2   6 8  2 4
        3 5   9 1
        4     0
         */
    }
}
