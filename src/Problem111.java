/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + getMin(minDepth(root.left), minDepth(root.right));
    }

    private int getMin(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return Math.min(a, b);
    }
}
