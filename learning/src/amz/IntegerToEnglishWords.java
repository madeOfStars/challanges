/*
https://leetcode.com/problems/integer-to-english-words/
 */

package amz;

import java.util.Map;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        final Map<Integer, String> map = Map.ofEntries(
                Map.entry(1, "One"),
                Map.entry(2, "Two"),
                Map.entry(3, "Three"),
                Map.entry(4, "Four"),
                Map.entry(5, "Five"),
                Map.entry(6, "Six"),
                Map.entry(7, "Seven"),
                Map.entry(8, "Eight"),
                Map.entry(9, "Nine"),
                Map.entry(10, "Ten"),
                Map.entry(20, "Twenty"),
                Map.entry(30, "Thirty"),
                Map.entry(40, "Forty"),
                Map.entry(50, "Fifty"),
                Map.entry(60, "Sixty"),
                Map.entry(70, "Seventy"),
                Map.entry(80, "Eighty"),
                Map.entry(90, "Ninety")
        );

        StringBuilder sb = new StringBuilder();

        int divisor = 1_000_000_000;

        for (int i = 0; i < 4; i++) {
            int threeDigits = num / divisor;

            if (threeDigits == 0) {
                divisor = divisor / 1000;
                continue;
            }

            String stringValue = threeDigits + "";

            if (stringValue.length() == 2) {
                stringValue = "0" + stringValue;
            } else if (stringValue.length() == 1) {
                stringValue = "00" + stringValue;
            }

            for (int j = 0; j < stringValue.length(); j++) {
                char c = stringValue.charAt(j);

                if (c == '0')
                    continue;

                if (j == 0) {
                    sb.append(" ").append(map.get(c - '0')).append(" ").append("Hundred");
                } else if (j == 1) {
                    if (stringValue.endsWith("11")) {
                        sb.append(" ").append("Eleven");
                        break;
                    } else if (stringValue.endsWith("12")) {
                        sb.append(" ").append("Twelve");
                        break;
                    } else if (stringValue.endsWith("13")) {
                        sb.append(" ").append("Thirteen");
                        break;
                    } else if (stringValue.endsWith("14")) {
                        sb.append(" ").append("Fourteen");
                        break;
                    } else if (stringValue.endsWith("15")) {
                        sb.append(" ").append("Fifteen");
                        break;
                    } else if (stringValue.endsWith("16")) {
                        sb.append(" ").append("Sixteen");
                        break;
                    } else if (stringValue.endsWith("17")) {
                        sb.append(" ").append("Seventeen");
                        break;
                    } else if (stringValue.endsWith("18")) {
                        sb.append(" ").append("Eighteen");
                        break;
                    } else if (stringValue.endsWith("19")) {
                        sb.append(" ").append("Nineteen");
                        break;
                    } else {
                        sb.append(" ").append(map.get((c - '0') * 10));
                    }
                } else {
                    sb.append(" ").append(map.get(c - '0'));
                }


            }

            switch (i) {
                case 0 -> sb.append(" Billion");
                case 1 -> sb.append(" Million");
                case 2 -> sb.append(" Thousand");
            }
            num = num % divisor;
            divisor = divisor / 1000;

        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords m = new IntegerToEnglishWords();

        System.out.println(m.numberToWords(123));
        System.out.println(m.numberToWords(12345));
        System.out.println(m.numberToWords(1234567));
        System.out.println(m.numberToWords(1234567890));
        System.out.println(m.numberToWords(13));
        System.out.println(m.numberToWords(1001));
    }
}
