package trees;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTreeTraversal {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        traverseHelper(root, output);
        return output;
    }

    protected abstract void traverseHelper(TreeNode root, List<Integer> output);
}
