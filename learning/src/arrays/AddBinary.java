/*
https://leetcode.com/problems/add-binary/
 */
package arrays;

public class AddBinary {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length()) + 1;
        StringBuilder sb = new StringBuilder(length);
        sb.setLength(length);

        int i = a.length() - 1;
        int j = b.length() - 1;
        int resultIndex = length - 1;
        int carry = 0;
        int total = 0;

        while (resultIndex >= 0) {
            int left = i < 0 ? 0 : a.charAt(i) - '0';
            int right = j < 0 ? 0 : b.charAt(j) - '0';

            total = left + right + carry;
            int value = total % 2;
            sb.setCharAt(resultIndex, Character.forDigit(value, 9));
            carry = total / 2;
            i--;
            j--;
            resultIndex--;
        }

        if (total == 0)
            sb.deleteCharAt(0);

        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("0", "0"));
    }
}
