import java.util.List;

/**
 * Created by admin on 2/29/16.
 */


public class Problem21 {
    //merge two sorted list

    /**
     * Definition for singly-linked list.
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        a.next = b;
        b = new ListNode(4);
        a.next.next = b;
        b = new ListNode(0);
        new Problem21().mergeTwoLists(a,b);
    }
}
