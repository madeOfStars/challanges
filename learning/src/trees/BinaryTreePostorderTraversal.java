package trees;

import java.util.List;

public class BinaryTreePostorderTraversal extends AbstractBinaryTreeTraversal {
    @Override
    protected void traverseHelper(TreeNode root, List<Integer> output) {
        if (root != null) {
            traverseHelper(root.left, output);
            traverseHelper(root.right, output);
            output.add(root.val);
        }
    }
}
