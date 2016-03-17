import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem98 {
    //recursive
    Integer value = null;
    public boolean isValidBST(TreeNode root) {
        return inOrderTraverse(root);
    }

    private boolean inOrderTraverse(TreeNode root) {
        if (root == null) return true;
        boolean flag = inOrderTraverse(root.left) && (value == null || value < root.val);
        if (!flag) return false;
        value = root.val;
        return inOrderTraverse(root.right);
    }
}
