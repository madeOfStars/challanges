/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();

                sum += polledNode.val;

                if (polledNode.left != null)
                    queue.add(polledNode.left);

                if (polledNode.right != null)
                    queue.add(polledNode.right);
            }

            result.add(sum / size);
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);

        t1.left.left = new TreeNode(15);
        t1.left.right = new TreeNode(7);

        System.out.println(m.averageOfLevels(t1));
    }
}
