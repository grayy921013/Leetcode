import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/27/16.
 */
public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            list.add(node.val);
        }
        return list;
    }
}
