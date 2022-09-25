import java.util.Arrays;
import java.util.List;

public class Main {
    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                    // second swap occurence
                else break;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(Arrays.toString(m.findTwoSwapped(List.of(1, 3, 2, 4))));
    }
}
