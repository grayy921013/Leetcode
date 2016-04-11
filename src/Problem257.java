import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/11/16.
 */
public class Problem257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,"", result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        path += root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        if (root.left != null) dfs(root.left, path + "->", result);
        if (root.right != null) dfs(root.right, path + "->", result);
    }
}
