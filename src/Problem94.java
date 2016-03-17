import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversal(list, root);
        return list;
    }

    private void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root.left != null) inorderTraversal(list, root.left);
        list.add(root.val);
        if (root.right != null) inorderTraversal(list, root.right);
    }
}
