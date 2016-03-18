/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
