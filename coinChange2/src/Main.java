import java.util.Arrays;
import java.util.List;

public class Main {
    public static int getWays(List<Integer> list, int length, int total) {
        if (length <= 0 && total >= 1)
            return 0;
        if (total == 0)
            return 1;
        if (total < 0)
            return 0;

        return getWays(list, length - 1, total) + getWays(list, length, total - list.get(length - 1));
    }
    public static void main(String[] args) {
        int n = 250;
        List<Integer> list = Arrays.asList(41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11);
        System.out.println(getWays(list, list.size(), n));
    }
}
