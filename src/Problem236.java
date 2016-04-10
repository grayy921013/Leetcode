import java.util.Stack;

/**
 * Created by Zhehui Zhou on 4/10/16.
 */
public class Problem236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pAns = new Stack<>();
        getAns(root, p, pAns);
        Stack<TreeNode> qAns = new Stack<>();
        getAns(root, q, qAns);
        TreeNode ancestor = null;
        while (!pAns.isEmpty() && !qAns.isEmpty()) {
            TreeNode pAn = pAns.pop();
            TreeNode qAn = qAns.pop();
            if (pAn == qAn) ancestor = pAn;
            else return ancestor;
        }
        return ancestor;
    }

    private boolean getAns(TreeNode root, TreeNode p, Stack<TreeNode> ancestors) {
        if (root == null) return false;
        if (p == root) {
            ancestors.push(root);
            return true;
        }
        if (getAns(root.left, p, ancestors) || getAns(root.right, p, ancestors)) {
            ancestors.push(root);
            return true;
        }
        return false;
    }
}
