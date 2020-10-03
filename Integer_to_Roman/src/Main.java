/*
Integer to Roman

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        final Map<Integer, String> romanNumerals = new HashMap<>(13);
        romanNumerals.put(1, "I");
        romanNumerals.put(4, "IV");
        romanNumerals.put(5, "V");
        romanNumerals.put(9, "IX");
        romanNumerals.put(10, "X");
        romanNumerals.put(40, "XL");
        romanNumerals.put(50, "L");
        romanNumerals.put(90, "XC");
        romanNumerals.put(100, "C");
        romanNumerals.put(400, "CD");
        romanNumerals.put(500, "D");
        romanNumerals.put(900, "CM");
        romanNumerals.put(1000, "M");

        int newNumLeadingDigit = num / 1000;
        int newNumToThePowerOf10 = newNumLeadingDigit * 1000;

        if (newNumLeadingDigit != 0 && !romanNumerals.containsKey(newNumToThePowerOf10)) {
            addTrailingNumerals(sb, newNumLeadingDigit, "M");
        } else if (romanNumerals.containsKey(newNumLeadingDigit)) {
            sb.append(romanNumerals.get(newNumLeadingDigit * 1000));
        }

        for (int i = 2; i >= 0; i--) {
            newNumLeadingDigit = num / (int)Math.pow(10, i) % 10;
            newNumToThePowerOf10 = newNumLeadingDigit * (int)Math.pow(10, i);

            if (newNumToThePowerOf10 < 9 * (int)Math.pow(10, i) && newNumToThePowerOf10 > 5 * (int)Math.pow(10, i)) {
                sb.append(romanNumerals.get(5 * (int)Math.pow(10, i)));
                newNumLeadingDigit -= 5;
            }

            if (newNumLeadingDigit != 0 && !romanNumerals.containsKey(newNumToThePowerOf10)) {
                addTrailingNumerals(sb, newNumLeadingDigit, romanNumerals.get((int)Math.pow(10, i)));
            } else if (romanNumerals.containsKey(newNumLeadingDigit)) {
                sb.append(romanNumerals.get(newNumLeadingDigit * (int)Math.pow(10, i)));
            }
        }

        return sb.toString();
    }

    private static void addTrailingNumerals(StringBuilder sb, int newNumLeadingDigit, String romanNumeral) {
        for (int i = 1; i <= newNumLeadingDigit; i++) {
            sb.append(romanNumeral);
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 4;
        int n3 = 9;
        int n4 = 58;
        int n5 = 1994;
        int n6 = 70;

        System.out.println(intToRoman(n1));
        System.out.println(intToRoman(n2));
        System.out.println(intToRoman(n3));
        System.out.println(intToRoman(n4));
        System.out.println(intToRoman(n5));
        System.out.println(intToRoman(n6));
    }
}
