import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(root, 0, result);
        return result;
    }

    private void bfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() <= depth) result.add(0, new ArrayList<>());
        List<Integer> list = result.get(result.size() - 1 - depth);
        list.add(node.val);
        bfs(node.left, depth + 1, result);
        bfs(node.right, depth + 1, result);
    }
}
