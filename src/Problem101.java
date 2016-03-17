/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left != null && right != null) return left.val == right.val &&
                isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        else return false;
    }
}
