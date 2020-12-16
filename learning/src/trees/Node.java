package trees;

public class Node extends TreeNode {
    Node next;

    public Node(int val) {
        super(val);
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
