/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
import java.util.*;

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return List.of();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();

                temp.add(polledNode.val);

                if (polledNode.left != null)
                    queue.add(polledNode.left);

                if (polledNode.right != null)
                    queue.add(polledNode.right);
            }

            result.add(new ArrayList<>(temp));
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);

        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        System.out.println(m.levelOrderBottom(t1));
    }
}
