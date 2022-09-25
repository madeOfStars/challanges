/*
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> output = new ArrayList<>();
        Stream.of(inorder(root1, new ArrayList()), inorder(root2, new ArrayList())).forEach(output::addAll);
        Collections.sort(output);
        return output;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(2);
        root2.left.left.left = new TreeNode(1);

        System.out.println(m.getAllElements(root1, root2));
    }
}
