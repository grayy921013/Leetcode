/**
 * Created by Zhehui Zhou on 3/28/16.
 */
public class Problem147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode cursor = head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while(cursor != null) {
            //from head to cursor, find a place to insert
            ListNode temp = cursor.next;
            cursor.next = null;
            ListNode search = dummy;
            while(search.next != null) {
                if (search.next.val >= cursor.val) break;
                search = search.next;
            }
            //insert after search
            ListNode next = search.next;
            search.next = cursor;
            cursor.next = next;
            cursor = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        System.out.println(new Problem147().insertionSortList(node));
    }
}
