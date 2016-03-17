/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(m > 1) {
            prev = prev.next;
            m--;
            n--;
        }
        //prev now points to the node prev to the reversing part
        ListNode node = prev.next;
        n--;
        ListNode tail = node;
        ListNode next = node.next;
        ListNode temp = node;
        while(n > 0) {
            temp = next;
            next = next.next;
            temp.next = node;
            n--;
        }
        prev.next = temp;
        tail.next = next;
        return dummy.next;
    }
}
