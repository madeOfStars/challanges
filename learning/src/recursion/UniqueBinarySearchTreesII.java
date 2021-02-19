/*
https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
package recursion;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (end < start) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);

            for (TreeNode leftTree : left) {
                for (TreeNode rightTree : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII ubs = new UniqueBinarySearchTreesII();

        List<TreeNode> treeNodeList = ubs.generateTrees(3);
        System.out.println(treeNodeList.size());
        treeNodeList.forEach(System.out::println);
    }
}
