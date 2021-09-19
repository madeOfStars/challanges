/*
https://leetcode.com/problems/triangle/
 */
import java.util.List;

public class Main {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int min = (int) (1e4 + 1);

        int[][] ans = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];

        ans[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                Integer value = triangle.get(i).get(j);
                if (j == 0) {
                    ans[i][j] = ans[i - 1][j] + value;
                } else if (j == i) {
                    ans[i][j] = ans[i - 1][j - 1] + value;
                } else {
                    ans[i][j] = Math.min(ans[i - 1][j - 1], ans[i - 1][j]) + value;
                }

                if (i == triangle.size() - 1)
                    min = Math.min(min, ans[i][j]);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Main m = new Main();

        List<List<Integer>> list1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(m.minimumTotal(list1));
    }
}
