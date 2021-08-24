/*
https://leetcode.com/problems/complex-number-multiplication/
 */
public class Main {
    public String complexNumberMultiply(String num1, String num2) {
        final String[] exp1 = num1.split("\\+");
        final String[] exp2 = num2.split("\\+");

        int coefficient1 = Integer.parseInt(exp1[1].substring(0, exp1[1].length() - 1));
        int coefficient2 = Integer.parseInt(exp2[1].substring(0, exp2[1].length() - 1));

        int realPart1 = Integer.parseInt(exp1[0]);
        int realPart2 = Integer.parseInt(exp2[0]);

        int resultRealPart1 = realPart1 * realPart2;
        int resultRealPart2 = coefficient1 * coefficient2;

        int resultComplexPart1 = realPart1 * coefficient2;
        int resultComplexPart2 = realPart2 * coefficient1;

        return (resultRealPart1 - resultRealPart2) + "+" + (resultComplexPart1 + resultComplexPart2) + "i";
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(m.complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(m.complexNumberMultiply("3+4i", "5+6i"));
    }
}
