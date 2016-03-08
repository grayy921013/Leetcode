/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode start = head;
        ListNode end = head;
        int length = 0;
        while (k > 0) {
            end = end.next;
            k--;
            length++;
            if (end == null) {
                //reach the end of the list, put end to head
                end = head;
                k = k % length;
            }
        }
        while (end.next != null) {
            end = end.next;
            start = start.next;
        }
        //start should be at the previous node of the result head
        end.next = head;
        head = start.next;
        start.next = null;
        return head;
    }
}
