import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem95 {
    public List<TreeNode> generateTrees(int n) {
        //we calculate n based on previous results, so we have to compute all previous results
        if (n == 0) return new ArrayList<>();
        List<TreeNode>[] array = new List[n + 1];
        array[0] = new ArrayList<>();
        array[0].add(null);
        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
            //for tree contain i nodes: we have k nodes in the left subtree, i - 1 - k nodes in the right subtree,
            //and the value of root should be k + 1
            //and we can get the structure of them from calculated results
            for (int k = 0; k <= i - 1; k++) {
                for (TreeNode leftNode : array[k]) {
                    for (TreeNode rightNode : array[i - 1 - k]) {
                        TreeNode root = new TreeNode(k + 1);
                        root.left = cloneTreeWithOffset(leftNode, 0);
                        root.right = cloneTreeWithOffset(rightNode, k + 1);
                        array[i].add(root);
                    }
                }
            }
        }
        return array[n];
    }

    private TreeNode cloneTreeWithOffset(TreeNode root, int offset) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = cloneTreeWithOffset(root.left, offset);
        newRoot.right = cloneTreeWithOffset(root.right, offset);
        return newRoot;
    }

    public static void main(String[] args) {
        new Problem95().generateTrees(1);
    }
}
