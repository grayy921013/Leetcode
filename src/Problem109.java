/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem109 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }


    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }
}
