/**
 * Created by Zhehui Zhou on 3/11/16.
 */
public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        int prev = head.val;
        ListNode now = head.next;
        ListNode cursor = head;
        while (now != null) {
            if (now.val != prev) {
                cursor.next = now;
                cursor = now;
                prev = now.val;
            }
            now = now.next
        }
        cursor.next = null;
        return head;
    }
}
