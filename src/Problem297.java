import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Zhehui Zhou on 4/14/16.
 */
public class Problem297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        //level traverse
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty() && count > 0) {
            int size = queue.size();
            while (size > 0) {
                if (builder.length() > 0) builder.append(".");
                size--;
                TreeNode node = queue.poll();
                if (node == null) {
                    builder.append("*");
                    continue;
                }
                else {
                    builder.append(node.val);
                    count--;
                }
                queue.offer(node.left);
                if (node.left != null) count++;
                queue.offer(node.right);
                if (node.right != null) count++;
                if (count == 0) break;
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] list = data.split("\\.");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty() && index < list.length) {
            TreeNode node = queue.poll();
            String s1 = list[index++];
            if (!s1.equals("*")) {
                int val = Integer.parseInt(s1);
                TreeNode n = new TreeNode(val);
                node.left = n;
                queue.offer(n);
            }
            if (index >= list.length) break;
            String s2 = list[index++];
            if (!s2.equals("*")) {
                int val = Integer.parseInt(s2);
                TreeNode n = new TreeNode(val);
                node.right = n;
                queue.offer(n);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Problem297 problem297 = new Problem297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        TreeNode right = new TreeNode(3);
//        right.left = new TreeNode(4);
//        right.right = new TreeNode(5);
//        root.right = right;
        System.out.println(problem297.serialize(problem297.deserialize(problem297.serialize(root))));
    }
}
