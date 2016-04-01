import java.util.Stack;

/**
 * Created by Zhehui Zhou on 4/1/16.
 */
public class Problem173 {
    TreeNode next = null;
    Stack<TreeNode> stack = new Stack<>();
    public Problem173(TreeNode root) {
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        next = stack.pop();
        if(next.right != null) pushLeft(next.right);
        return true;
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        return next.val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        Problem173 problem173 = new Problem173(node);
        while (problem173.hasNext()) {
            System.out.println(problem173.next());
        }
    }
}
