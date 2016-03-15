/**
 * Created by admin on 2/29/16.
 */
public class ListNode {
    //ListNode for common use
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode cursor = this;
        StringBuilder builder = new StringBuilder("[");
        while (cursor != null) {
            builder.append(cursor.val);
            if (cursor.next != null) builder.append(",");
            cursor = cursor.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
