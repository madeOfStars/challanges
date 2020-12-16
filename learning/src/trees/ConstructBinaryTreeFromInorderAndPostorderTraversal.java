package trees;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        int splitPosition = -1;

        int currentRootValue = postorder[postorder.length - 1];
        TreeNode t = new TreeNode(currentRootValue);

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == currentRootValue) {
                splitPosition = i;
                break;
            }
        }

        t.left = buildTree(Arrays.copyOf(inorder, splitPosition), Arrays.copyOf(postorder, splitPosition));
        t.right = buildTree(Arrays.copyOfRange(inorder, splitPosition + 1, inorder.length), Arrays.copyOfRange(postorder, splitPosition, postorder.length - 1));

        return t;
    }

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return buildTree2(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    private static TreeNode buildTree2(int[] inorder, int inStart, int inEnd,
                                       int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = buildTree2(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
        root.right = buildTree2(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder1 = new int[]{9, 3, 15, 20, 7};
        int[] postorder1 = new int[]{9, 15, 7, 20, 3};

        TreeNode tree = buildTree2(inorder1, postorder1);

        System.out.println(tree);
    }
}
