import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, 0, k, n, new LinkedList<>(), ans);
        return ans;
    }

    private void helper(int index, int sum, int k, int n, LinkedList<Integer> tmpList, List<List<Integer>> ans) {
        if (tmpList.size() == k && sum == n) {
            ans.add(new LinkedList<>(tmpList));
            return;
        }

        if (sum > n) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            tmpList.add(i);
            helper(i + 1, sum + i, k, n, tmpList, ans);
            tmpList.removeLast();
        }
    }

    public static void main(String[] args) {
        Main2 m = new Main2();

        System.out.println(m.combinationSum3(3, 7));
        System.out.println(m.combinationSum3(3, 9));
        System.out.println(m.combinationSum3(4, 1));
        System.out.println(m.combinationSum3(3, 2));
        System.out.println(m.combinationSum3(9, 45));
        System.out.println(m.combinationSum3(2, 18));
    }
}
