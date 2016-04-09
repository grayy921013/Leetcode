/**
 * Created by Zhehui Zhou on 4/9/16.
 */
public class Problem230 {
    int k;
    int value;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrderTraverse(root);
        return value;
    }

    private void inOrderTraverse(TreeNode node) {
        if(node.left != null) inOrderTraverse(node.left);
        k--;
        if(k == 0) value = node.val;
        if (k > 0 && node.right != null) inOrderTraverse(node.right);
    }
}
