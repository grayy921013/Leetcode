import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, root, 0);
        return result;
    }

    private void traverse(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) return;
        if (result.size() <= level) result.add(new ArrayList<>());
        if (level % 2 == 0) result.get(level).add(node.val);
        else result.get(level).add(0, node.val);
        traverse(result, node.left, level + 1);
        traverse(result, node.right, level + 1);
    }
}
