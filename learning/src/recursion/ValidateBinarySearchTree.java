/*
https://leetcode.com/problems/validate-binary-search-tree/
 */
package recursion;

import trees.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();

        TreeNode node = new TreeNode(5);

        node.left = new TreeNode(4);
        node.right = new TreeNode(6);

        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(7);

        TreeNode node1 = new TreeNode(2);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(3);

        node2.left = new TreeNode(1);
        node2.right = new TreeNode(5);

        node2.left.left = new TreeNode(0);
        node2.left.right = new TreeNode(2);

        node2.right.left = new TreeNode(4);
        node2.right.right = new TreeNode(6);


        System.out.println(vbst.isValidBST(node));
        System.out.println(vbst.isValidBST(node1));
        System.out.println(vbst.isValidBST(node2));
    }
}
