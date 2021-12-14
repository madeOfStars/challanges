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

    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();

                sum += polledNode.val;

                if (polledNode.left != null)
                    queue.add(polledNode.left);

                if (polledNode.right != null)
                    queue.add(polledNode.right);
            }

            list.add(sum);
        }

        int[] ans = new int[list.size() + 1];
        ans[0] = 0;
        ans[1] = list.get(0);

        for (int i = 2; i <= list.size(); i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + list.get(i - 1));
        }

        return ans[list.size()];
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        t1.left.right = new TreeNode(3);
        t1.right.right = new TreeNode(1);

        //System.out.println(m.rob(t1));

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);

        t2.left.right = new TreeNode(4);

        System.out.println(m.rob(t2));
    }
}
