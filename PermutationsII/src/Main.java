import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, new LinkedList<>(), ans, used);
        return new ArrayList<>(ans);
    }

    private void helper(int[] nums, LinkedList<Integer> tmpList, Set<List<Integer>> ans, boolean[] used) {
        if (tmpList.size() == nums.length) {
            ans.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                tmpList.add(nums[i]);
                used[i] = true;
                helper(nums, tmpList, ans, used);
                tmpList.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(m.permuteUnique(new int[]{1, 2, 3}));
    }
}
