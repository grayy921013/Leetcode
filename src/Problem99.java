import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem99 {
    //traverse to find two incorrect node
    //use stack for this time
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        TreeNode prev = null, first = null, second = null;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            pushLeft(stack, cur.right);
            if (prev != null && prev.val > cur.val) {
                if (first == null) {
                    first = prev;
                }
                second = cur;
            }
            prev = cur;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
