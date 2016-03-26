/**
 * Created by Zhehui Zhou on 3/26/16.
 */
public class Problem143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        //first, reverse the list direction in the second half of the list
        int count = 0;
        ListNode fast = head;
        ListNode slow = head;
        //find middle
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse list after slow pointer
        if (slow.next != null) {
            ListNode next = slow.next;
            slow.next = null;
            while (next != null) {
                ListNode temp = next.next;
                next.next = slow;
                slow = next;
                next = temp;
            }
        }
        //slow pointer is now at the tail of the list
        ListNode headNext = head.next;
        ListNode tailNext = slow.next;
        while(tailNext != null) {
            ListNode headTemp = headNext.next;
            ListNode tailTemp = tailNext.next;
            head.next = slow;
            slow.next = headNext;
            head = headNext;
            slow = tailNext;
            headNext = headTemp;
            tailNext = tailTemp;
        }
    }
}
