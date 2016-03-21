/**
 * Created by Zhehui Zhou on 3/21/16.
 */
public class Problem117 {
    public void connect(TreeLinkNode root) {
        //TreeLinkNode lastRowFirst = root;
        TreeLinkNode thisRowFirst = null;
        TreeLinkNode cursor = root;
        boolean leftVisited = false;
        boolean rightVisited = false;
        while(root != null) {
            if (root.left != null && !leftVisited) {
                if (thisRowFirst == null) {
                    thisRowFirst = root.left;
                    cursor = thisRowFirst;
                } else {
                    cursor.next = root.left;
                    cursor = cursor.next;
                }
                leftVisited = true;
            } else if (root.right != null && !rightVisited) {
                if (thisRowFirst == null) {
                    thisRowFirst = root.right;
                    cursor = thisRowFirst;
                } else {
                    cursor.next = root.right;
                    cursor = cursor.next;
                }
                rightVisited = true;
            } else if (root.next != null) {
                root = root.next;
                leftVisited = false;
                rightVisited = false;
            } else {
                //to next row
                if (thisRowFirst != null) {
                    root = thisRowFirst;
                    thisRowFirst = null;
                    leftVisited = false;
                    rightVisited = false;
                } else {
                    return;
                }
            }
        }
    }
}
