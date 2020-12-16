package trees;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preorderStart = 0;
        int inorderStart = 0;
        int inorderEnd = inorder.length - 1;
        return buildTree(preorder, inorder, preorderStart, inorderStart, inorderEnd);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart, int inorderStart, int inorderEnd) {

        if (preorderStart > preorder.length - 1 || inorderStart > inorderEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);

        int inIndex = 0;

        for (int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, preorderStart + 1, inorderStart, inIndex - 1);
        root.right = buildTree(preorder, inorder, preorderStart + inIndex - inorderStart + 1, inIndex + 1, inorderEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder1 = new int[]{9, 3, 15, 20, 7};
        int[] preorder1 = new int[]{3, 9, 20, 15, 7};

        TreeNode tree = buildTree(preorder1, inorder1);

        System.out.println(tree);
    }
}
