import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;

            if (nums[num] < 0) {
                res.add(num + 1);
            }

            nums[num] *= -1;
        }

        return res;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
