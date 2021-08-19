/*
https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxProduct(TreeNode root) {
        List<Long> sums = new ArrayList<>();
        long totalSum = sum(root, sums);

        long result = 0;
        long mod = (long) (1e9 + 7);

        for (long sum : sums) {
            result = Math.max(result, sum * (totalSum - sum));
        }

        return (int) (result % mod);
    }

    private long sum(TreeNode root, List<Long> sums) {
        if (root == null) {
            return 0;
        }

        long left = sum(root.left, sums);
        long right = sum(root.right, sums);

        long totalSum = root.val + left + right;
        sums.add(totalSum);

        return totalSum;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);

        System.out.println(m.maxProduct(t1));
    }
}
