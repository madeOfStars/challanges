/*
https://leetcode.com/problems/add-strings/
 */
public class Main {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int length = Math.max(num1.length(), num2.length());
        int delta1 = length - num1.length();
        int delta2 = length - num2.length();

        int carryDigit = 0;
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            int digit1 = count < num1.length() ? Character.digit(num1.charAt(i - delta1), 10) : 0;
            int digit2 = count < num2.length() ? Character.digit(num2.charAt(i - delta2), 10) : 0;

            int total = digit1 + digit2 + carryDigit;
            carryDigit = total / 10;

            sb.append(total % 10);
            count++;
        }

        if (carryDigit > 0)
            sb.append(carryDigit);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.addStrings("11", "123"));
        System.out.println(m.addStrings("456", "77"));
        System.out.println(m.addStrings("0", "0"));
        System.out.println(m.addStrings("999", "1"));
    }
}
