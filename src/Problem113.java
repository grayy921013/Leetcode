import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/19/16.
 */
public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> list = new ArrayList<>();
        traverse(result, list, root, sum);
        return result;
    }

    private void traverse(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) result.add(new ArrayList<>(list));
        } else if (root.left == null) traverse(result, list, root.right, sum - root.val);
        else if (root.right == null) traverse(result, list, root.left, sum - root.val);
        else {
            traverse(result, list, root.left, sum - root.val);
            traverse(result, list, root.right, sum - root.val);
        }
        list.remove(list.size() - 1);
    }
}
