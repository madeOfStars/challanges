/*
https://leetcode.com/problems/path-sum-iii/
 */

package trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumIIIWithPath {
    public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return pathRoot(root, sum, new ArrayList<>()) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathRoot(TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return 0;
        path.add(root.val);

        int count = 0;
        ArrayList<Integer> pathLeft = new ArrayList<>(path);
        ArrayList<Integer> pathRight = new ArrayList<>(path);

        count += pathRoot(root.left, sum - root.val, pathLeft);
        count += pathRoot(root.right, sum - root.val, pathRight);

        if (sum - root.val == 0) {
            count++;
            System.out.println(pathLeft);
        }

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

        pathSum(root, 8);

//        System.out.println(pathSum(root, 8));
    }
}
