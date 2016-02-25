/**
 * Created by admin on 2/25/16.
 */
public class Problem19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode tail = head;
        while (n > 0) {
            tail = tail.next;
            n--;
        }
        if (tail == null) return head.next;
        while (tail.next != null) {
            tail = tail.next;
            front = front.next;
        }
        //head will now point to the previous node of the node that should be deleted
        front.next = front.next.next;
        return head;
    }
}
