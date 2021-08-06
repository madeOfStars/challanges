/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
import java.util.*;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return List.of();

        int direction = 1;

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();
                temp.add(polledNode.val);

                if (polledNode.left != null)
                    queue.add(polledNode.left);

                if (polledNode.right != null)
                    queue.add(polledNode.right);

            }

            if (direction == -1)
                Collections.reverse(temp);

            result.add(new ArrayList<>(temp));
            direction *= -1;
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);

        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        System.out.println(m.zigzagLevelOrder(t1));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        t2.left.left = new TreeNode(4);

        t2.right.right = new TreeNode(5);

        System.out.println(m.zigzagLevelOrder(t2));
    }
}
