/**
 * Created by Zhehui Zhou on 3/19/16.
 */
public class Problem112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        if (root.left == null) return hasPathSum(root.right, sum - root.val);
        if (root.right == null) return hasPathSum(root.left, sum - root.val);
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
