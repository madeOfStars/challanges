/*
https://leetcode.com/problems/target-sum/
 */
package queue_and_stack;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TargetSum1 {
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0)
            return 0;
        TreeNode treeNode = new TreeNode(0);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        int arrayIndex = 0;

        while (arrayIndex < nums.length) {
            int size = queue.size();
            int currentArrayValue = nums[arrayIndex];

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();

                polledNode.left = new TreeNode(currentArrayValue * -1);
                queue.add(polledNode.left);
                polledNode.right = new TreeNode(currentArrayValue);
                queue.add(polledNode.right);
            }

            arrayIndex++;
        }

        return count(treeNode.left, S) + count(treeNode.right, S);
    }

    private static int count(TreeNode tree, int sum) {
        if (tree == null)
            return 0;

        if (tree.left == null && tree.right == null && sum - tree.val == 0)
            return 1;

        return count(tree.left, sum - tree.val) + count(tree.right, sum - tree.val);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 1, 1, 1};
        int[] nums2 = new int[]{6, 44, 30, 25, 8, 26, 34, 22, 10, 18, 34, 8, 0, 32, 13, 48, 29, 41, 16, 30};
        int[] nums3 = new int[]{1, 0};
        int[] nums4 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] nums5 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] nums6 = new int[]{1000};

        int sum1 = 3;
        int sum2 = 12;
        int sum3 = 1;
        int sum4 = 1;
        int sum5 = 0;
        int sum6 = -1000;

        System.out.println(findTargetSumWays(nums1, sum1));
        System.out.println(findTargetSumWays(nums2, sum2));
        System.out.println(findTargetSumWays(nums3, sum3));
        System.out.println(findTargetSumWays(nums4, sum4));
        System.out.println(findTargetSumWays(nums5, sum5));
        System.out.println(findTargetSumWays(nums6, sum6));
    }
}
