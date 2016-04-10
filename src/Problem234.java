/**
 * Created by Zhehui Zhou on 4/9/16.
 */
public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode next = head.next;
        ListNode pre = head;
        //find mid pointer, and reverse head half part
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = next;
            next = next.next;
            slow.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if(fast.next == null) {
            slow =slow.next;
        }
        //compare from mid to head/tail
        while(next != null) {
            if(slow.val != next.val) {
                return false;
            }
            slow = slow.next;
            next = next.next;
        }
        return true;

    }
}
