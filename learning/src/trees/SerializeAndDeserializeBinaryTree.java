package trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        ArrayDeque<String> nodes = new ArrayDeque<>();
        nodes.add(root.val + "");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode polledNode = queue.poll();

            if (polledNode != null) {
                queue.add(polledNode.left);
                queue.add(polledNode.right);

                nodes.add(polledNode.left != null ? polledNode.left.val + "" : "null");
                nodes.add(polledNode.right != null ? polledNode.right.val + "" : "null");
            }
        }

        while (nodes.peekLast().equals("null")) {
            nodes.removeLast();
        }

        StringBuilder stringBuilder = new StringBuilder(nodes.poll() + "");
        for (String node : nodes) {
            stringBuilder.append(",").append(node);
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.right.left.right = new TreeNode(6);

        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();

        System.out.println(serializeAndDeserializeBinaryTree.serialize(root));
    }
}
