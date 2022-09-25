import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, 0, target, new LinkedList<>(), ans);

        return ans;
    }

    private void helper(int[] candidates, int index, int target, LinkedList<Integer> tmpList, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(tmpList));
        }

        if (target < 0)
            return;

        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            tmpList.add(candidate);
                        helper(candidates, i, target - candidate, tmpList, ans);
            tmpList.removeLast();
        }
    }

    public static void main(String[] args) {
        Main2 m = new Main2();

        System.out.println(m.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(m.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(m.combinationSum(new int[]{2}, 1));
        System.out.println(m.combinationSum(new int[]{1}, 1));
        System.out.println(m.combinationSum(new int[]{1, 1}, 2));
        System.out.println(m.combinationSum(new int[]{1, 2}, 4));
        System.out.println(m.combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9));
    }
}
