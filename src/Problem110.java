/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getHeight(root) > 0;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int lh = getHeight(node.left);
        if (lh < 0) return -1;
        int rh = getHeight(node.right);
        if (rh < 0 || Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
}
