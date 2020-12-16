package trees;

import java.util.List;

public class BinaryTreeInorderTraversal extends AbstractBinaryTreeTraversal {

    @Override
    protected void traverseHelper(TreeNode root, List<Integer> output) {
        if (root != null) {
            traverseHelper(root.left, output);
            output.add(root.val);
            traverseHelper(root.right, output);
        }
    }
}
