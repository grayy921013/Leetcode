/**
 * Created by Zhehui Zhou on 3/11/16.
 */
public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode now = head;
        ListNode newHead = null;
        ListNode cursor = null;
        while (now != null) {
            if ((prev == null || now.val != prev.val) && (now.next == null || now.next.val != now.val)) {
                if (newHead == null) {
                    newHead = now;
                    cursor = now;
                } else {
                    cursor.next = now;
                    cursor = now;
                }
            }
            prev = now;
            now = now.next;
        }
        if (cursor != null ) cursor.next = null;
        return newHead;
    }
}
