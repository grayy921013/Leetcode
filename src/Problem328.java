/**
 * Created by Zhehui Zhou on 4/25/16.
 */
public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode oddCursor = oddDummy;
        ListNode evenCursor = evenDummy;
        boolean odd = true;
        while (head != null) {
            if (odd) {
                oddCursor.next = head;
                oddCursor = head;
            } else {
                evenCursor.next = head;
                evenCursor = head;
            }
            head = head.next;
            odd = !odd;
        }
        oddCursor.next = evenDummy.next;
        evenCursor.next = null;
        return oddDummy.next;
    }
}
