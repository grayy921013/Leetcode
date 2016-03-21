/**
 * Created by Zhehui Zhou on 3/21/16.
 */
public class Problem116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode lastRowFirst = root;
        while(root != null && root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
                root = root.next;
            } else {
                root = lastRowFirst.left;
                lastRowFirst = root;
            }
        }
    }
}
