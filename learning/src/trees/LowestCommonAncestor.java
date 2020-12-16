/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

package trees;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null)
            return root;

        return leftNode != null ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(4);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}
