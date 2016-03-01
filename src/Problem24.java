/**
 * Created by admin on 3/1/16.
 */
public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = head.next;
        head.next = node.next;
        node.next = head;
        head.next = swapPairs(head.next);
        head = node;
        return head;
    }
}
