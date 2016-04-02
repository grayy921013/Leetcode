/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cursor = head;
        ListNode last = dummy;
        while (cursor != null) {
            if(cursor.val == val) {
                last.next = cursor.next;
            } else {
                last = last.next;
            }
            cursor = cursor.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        new Problem203().removeElements(node, 1);
    }
}
