/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Main {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        int mid = (right + left) / 2;

        if (right <= left)
            return null;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, left, mid);
        root.right = helper(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = {-10, -3, 0, 5, 9};
        System.out.println(m.sortedArrayToBST(nums1));

        int[] nums2 = {1, 3};
        System.out.println(m.sortedArrayToBST(nums2));
    }
}
