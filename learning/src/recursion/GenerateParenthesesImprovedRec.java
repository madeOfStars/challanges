package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesImprovedRec {
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return List.of();

        List<String> result = new ArrayList<>();

        generateParenthesis(n, n, result, new char[2 * n], 0);

        return result;
    }

    private void generateParenthesis(int right, int left, List<String> result, char[] str, int count) {
        if (left < 0 || right < left)
            return;

        if (right == 0) {
            result.add(new String(str));
            return;
        }

        if (left > 0) {
            str[count] = '(';
            generateParenthesis(right, left - 1, result, str, count + 1);
        }
        if (right > left) {
            str[count] = ')';
            generateParenthesis(right - 1, left, result, str, count + 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesesImprovedRec gp = new GenerateParenthesesImprovedRec();

        System.out.println(gp.generateParenthesis(3));
    }
}
