/**
 * Created by Zhehui Zhou on 3/19/16.
 */
public class Problem114 {
    public void flatten(TreeNode root) {
        getFlatten(root);
    }

    private TreeNode getFlatten(TreeNode root) {
        //return the leaf node of the flatten result
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root;
        } if (root.left == null) {
            return getFlatten(root.right);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return getFlatten(root.right);
        } else {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            getFlatten(root.right).right = temp;
            return getFlatten(temp);
        }
    }
}
