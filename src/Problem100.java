/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p != null && q != null) return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
