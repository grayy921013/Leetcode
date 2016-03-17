import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(root, 0, result);
        return result;
    }

    private void bfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() <= depth) result.add(new ArrayList<>());
        List<Integer> list = result.get(depth);
        list.add(node.val);
        bfs(node.left, depth + 1, result);
        bfs(node.right, depth + 1, result);
    }
}
