/*
https://leetcode.com/problems/spiral-matrix-ii/
 */
import java.util.Arrays;

public class Main {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int count = 1;

        int i = 0;
        int j = 0;

        while (count <= n * n) {
            while (j < n && ans[i][j] == 0) {
                ans[i][j++] = count++;
            }
            i++;
            j--;
            while (i < n && ans[i][j] == 0) {
                ans[i++][j] = count++;
            }
            i--;
            j--;
            while (j >= 0 && ans[i][j] == 0) {
                ans[i][j--] = count++;
            }
            i--;
            j++;
            while (i >= 0 && ans[i][j] == 0) {
                ans[i--][j] = count++;
            }
            i++;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(Arrays.deepToString(m.generateMatrix(3)));
        System.out.println(Arrays.deepToString(m.generateMatrix(2)));
        System.out.println(Arrays.deepToString(m.generateMatrix(1)));
    }
}
