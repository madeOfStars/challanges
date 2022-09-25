class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Main {
    public Node connect(Node root) {
        if (root == null)
            return null;

        root.next = null;

        helper(root);
        return root;
    }

    private void helper(Node root) {
        if (root == null)
            return;

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                Node tmp = root;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                root.left.next = tmp.left != null ? tmp.left : tmp.right;
            }
        }

        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left != null ? root.next.left : root.next.right;
            }
        }
        if (root.right != null)
            helper(root.right);
        if (root.left != null) {
            helper(root.left);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);

        n1.left.left = new Node(4);
        n1.right.right = new Node(5);

        //System.out.println(m.connect(n1));

        Node n2 = new Node(1);
        n2.left = new Node(2);
        n2.right = new Node(3);

        n2.left.left = new Node(4);
        n2.left.right = new Node(5);
        n2.right.right = new Node(6);

        n2.left.left.left = new Node(7);
        n2.right.right.right = new Node(8);

        System.out.println(m.connect(n2));

        Node n3 = new Node(1);
        n3.right = new Node(2);

        System.out.println(m.connect(n3));
    }
}