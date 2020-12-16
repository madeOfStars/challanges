/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

package trees;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    private static class TreeNodeWrapper {

        public TreeNodeWrapper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        TreeNode node;
        int level;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNodeWrapper> nodes = new LinkedList<>();

        nodes.add(new TreeNodeWrapper(root, 0));
        result.add(Collections.singletonList(root.val));

        while (!nodes.isEmpty()) {
            TreeNodeWrapper polledNode = nodes.poll();

            int nextLevel = polledNode.level + 1;
            if (polledNode.node.left != null) {
                nodes.add(new TreeNodeWrapper(polledNode.node.left, nextLevel));
                if (nextLevel >= result.size())
                    result.add(new ArrayList<>());
                result.get(nextLevel).add(polledNode.node.left.val);
            }

            if (polledNode.node.right != null) {
                nodes.add(new TreeNodeWrapper(polledNode.node.right, nextLevel));
                if (nextLevel >= result.size())
                    result.add(new ArrayList<>());
                result.get(nextLevel).add(polledNode.node.right.val);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3, new TreeNode(9, new TreeNode(5), null), new TreeNode(20, new TreeNode(15, new TreeNode(77), null), new TreeNode(7)));

        List<List<Integer>> result = levelOrder(t1);
        System.out.println(result);
    }
}
