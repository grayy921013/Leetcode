import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/27/16.
 */
public class Problem145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastPop = root;
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && lastPop != node.left && lastPop != node.right) {
                stack.push(node.left);
            } else if (node.right != null && lastPop != node.right) {
                stack.push(node.right);
            } else {
                stack.pop();
                list.add(node.val);
                lastPop = node;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(new Problem145().postorderTraversal(node));
    }
}
