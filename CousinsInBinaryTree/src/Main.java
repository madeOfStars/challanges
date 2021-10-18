/*
https://leetcode.com/problems/cousins-in-binary-tree/
 */
import java.util.LinkedList;
import java.util.Queue;

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


    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean isXFound = false;
            boolean isYFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();

                if (polledNode.left != null && polledNode.right != null && ((polledNode.left.val == x && polledNode.right.val == y) || polledNode.right.val == x && polledNode.left.val == y))
                    return false;

                if (!isXFound && polledNode.val == x)
                    isXFound = true;

                if (!isYFound && polledNode.val == y)
                    isYFound = true;

                if (isXFound && isYFound)
                    return true;

                if (polledNode.left != null) {
                    queue.add(polledNode.left);
                }

                if (polledNode.right != null) {
                    queue.add(polledNode.right);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);

        n1.left.right = new TreeNode(4);
        n1.right.right = new TreeNode(5);

        System.out.println(m.isCousins(n1, 5, 4));

        TreeNode n2 = new TreeNode(1);
        n2.left = new TreeNode(2);
        n2.right = new TreeNode(3);

        n1.left.left = new TreeNode(4);

        System.out.println(m.isCousins(n2, 4, 3));
    }
}
