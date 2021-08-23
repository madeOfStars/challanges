/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k, new HashSet<>());
    }

    private boolean helper(TreeNode root, int k, Set<Integer> missing) {
        if (root == null)
            return false;

        if (missing.contains(root.val))
            return true;

        missing.add(k - root.val);

        return helper(root.left, k, missing) || helper(root.right, k ,missing);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(6);

        t1.left.left = new TreeNode(2);
        t1.left.right = new TreeNode(4);

        t1.right.right = new TreeNode(7);

        System.out.println(m.findTarget(t1, 9));
        System.out.println(m.findTarget(t1, 28));

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);

        System.out.println(m.findTarget(t2, 4));
        System.out.println(m.findTarget(t2, 1));
    }
}
