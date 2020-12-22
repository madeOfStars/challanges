/*
https://leetcode.com/problems/path-sum-iii/
 */

package trees;

public class PathSumIII {
    public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return pathRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathRoot(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int count = 0;
        if (sum - root.val == 0)
            count++;

        count += pathRoot(root.left, sum - root.val);
        count += pathRoot(root.right, sum - root.val);

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 8));
    }
}
