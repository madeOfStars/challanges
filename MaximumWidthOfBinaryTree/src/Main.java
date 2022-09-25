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

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int max = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            Integer left = null;

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();

                if (polledNode != null) {
                    queue.add(polledNode.left);
                    queue.add(polledNode.right);

                    if (left == null) {
                        left = i;
                    } else {
                        max = Math.max(max, i - left + 1);
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);

        t1.left.left = new TreeNode(5);
        t1.left.right = new TreeNode(3);

        t1.right.right = new TreeNode(9);

        //System.out.println(m.widthOfBinaryTree(t1)); // 4

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(2);

        t2.left.left = new TreeNode(5);
        t2.left.right = new TreeNode(3);

        //System.out.println(m.widthOfBinaryTree(t2)); // 2

        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(3);
        t3.right = new TreeNode(2);

        t3.left.left = new TreeNode(5);

        //System.out.println(m.widthOfBinaryTree(t3)); // 2

        TreeNode t4 = new TreeNode(1);
        t4.left = new TreeNode(3);
        t4.right = new TreeNode(2);

        t4.left.left = new TreeNode(5);
        t4.left.left.left = new TreeNode(6);

        t4.right.right = new TreeNode(9);
        t4.right.right.right = new TreeNode(7);

        System.out.println(m.widthOfBinaryTree(t4));
    }
}
