/*
https://leetcode.com/problems/same-tree/
 */
package recursion;

import trees.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null)
            return false;

        if (q == null)
            return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree st = new SameTree();

        TreeNode p1 = new TreeNode(1);

        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);

        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        TreeNode p2 = new TreeNode(1);

        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);

        q2.right = new TreeNode(2);

        TreeNode p3 = new TreeNode(1);

        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);

        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println(st.isSameTree(p1, q1));
        System.out.println(st.isSameTree(p2, q2));
        System.out.println(st.isSameTree(p3, q3));
    }
}
