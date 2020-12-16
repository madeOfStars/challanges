package trees;

import static trees.TraverseOrder.*;

public class Main {

    private static final TreeNode T1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    private static final TreeNode T2 = null;
    private static final TreeNode T3 = new TreeNode(1);
    private static final TreeNode T4 = new TreeNode(1, new TreeNode(2, null, null), null);
    private static final TreeNode T5 = new TreeNode(1, null, new TreeNode(2, null, null));

    private static void traverse(TraverseOrder order) {
        switch (order) {
            case PREORDER:
                traverse(new BinaryTreePreorderTraversal());
                break;
            case INORDER:
                traverse(new BinaryTreeInorderTraversal());
                break;
            case POSTORDER:
                traverse(new BinaryTreePostorderTraversal());
                break;
            default:
                throw new RuntimeException("Unsupported Order");
        }
    }

    private static void traverse(AbstractBinaryTreeTraversal binaryTreePreorderTraversal) {
        System.out.println(binaryTreePreorderTraversal.traverse(T1));
        System.out.println(binaryTreePreorderTraversal.traverse(T2));
        System.out.println(binaryTreePreorderTraversal.traverse(T3));
        System.out.println(binaryTreePreorderTraversal.traverse(T4));
        System.out.println(binaryTreePreorderTraversal.traverse(T5));
    }

    public static void main(String[] args) {
        traverse(PREORDER);
        traverse(INORDER);
        traverse(POSTORDER);
    }
}
