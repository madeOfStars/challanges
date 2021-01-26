/*
https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
package recursion;

import trees.TreeNode;

public class SearchBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        SearchBinarySearchTree sbst = new SearchBinarySearchTree();

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(sbst.searchBST(root, 2));
    }
}
