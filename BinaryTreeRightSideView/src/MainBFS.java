/*
https://leetcode.com/problems/binary-tree-right-side-view/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainBFS {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return List.of();

        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeNode polledNode = null;
            for (int i = 0; i < size; i++) {
                polledNode = queue.poll();

                if (polledNode.left != null)
                    queue.add(polledNode.left);

                if (polledNode.right != null)
                    queue.add(polledNode.right);
            }

            ans.add(polledNode.val);
        }

        return ans;
    }

    public static void main(String[] args) {
        MainBFS m = new MainBFS();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        t1.left.right = new TreeNode(5);
        t1.right.right = new TreeNode(4);

        t1.left.right.left = new TreeNode(6);

        System.out.println(m.rightSideView(t1));
    }
}
