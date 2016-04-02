import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        //BFS
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                //level traverse
                TreeNode node = queue.poll();
                if (result.size() == level) result.add(node.val);
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
                count--;
            }
            level++;
        }
        return result;
    }
}
