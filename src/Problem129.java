/**
 * Created by Zhehui Zhou on 3/23/16.
 */
public class Problem129 {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return result;
        dfs(0, root);
        return result;
    }

    private void dfs(int number, TreeNode node) {
        if (node.left == null && node.right == null) result += number * 10 + node.val;
        if (node.left != null) dfs(number * 10 + node.val, node.left);
        if (node.right != null) dfs(number * 10 + node.val, node.right);
    }
}
