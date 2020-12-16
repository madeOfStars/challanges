package trees;

import java.util.List;

public class BinaryTreePreorderTraversal extends AbstractBinaryTreeTraversal {

    @Override
    protected void traverseHelper(TreeNode root, List<Integer> output) {
        if (root != null) {
            output.add(root.val);
            traverseHelper(root.left, output);
            traverseHelper(root.right, output);
        }
    }
}
