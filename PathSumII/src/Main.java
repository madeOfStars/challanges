/*
https://leetcode.com/problems/path-sum-ii/
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return List.of();

        List<List<Integer>> result = new ArrayList<>();

        helper(root, result, new ArrayList<>(), 0, targetSum);

        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, List<Integer> path, int currentSum, int targetSum) {
        if (root == null)
            return;

        currentSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && currentSum == targetSum)
            result.add(new ArrayList<>(path));

        helper(root.left, result, path, currentSum, targetSum);
        helper(root.right, result, path, currentSum, targetSum);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(5);

        t1.left = new TreeNode(4);
        t1.right = new TreeNode(8);

        t1.left.left = new TreeNode(11);
        t1.right.left = new TreeNode(13);
        t1.right.right = new TreeNode(4);

        t1.left.left.left = new TreeNode(7);
        t1.left.left.right = new TreeNode(2);
        t1.right.right.left = new TreeNode(5);
        t1.right.right.right = new TreeNode(1);

        System.out.println(m.pathSum(t1, 22));

        TreeNode t2 = new TreeNode(1);

        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        System.out.println(m.pathSum(t2, 5));
    }
}
