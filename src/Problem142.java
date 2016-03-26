/**
 * Created by Zhehui Zhou on 3/26/16.
 */
public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null & slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null; // no cycle
        //two point, one start from meeting point, one start from the head
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
