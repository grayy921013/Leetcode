/**
 * Created by Zhehui Zhou on 3/22/16.
 */
public class Problem124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //use dfs, return two value max, max denotes the max path length to the leafs starting from this node,
        //max is the max path sum who "take turn" at this node
        //sum = leftchild.max + rightchild.max + val
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);
        max = Math.max(max, (leftMax > 0 ? leftMax : 0) + (rightMax > 0 ? rightMax : 0) + node.val);
        return Math.max(Math.max(leftMax, rightMax), 0) + node.val;
    }
}
