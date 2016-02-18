/**
 * Created by admin on 2/18/16.
 */
public class Problem2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        int remain = 0;
        ListNode root = null;
        while(l1 != null || l2 != null || remain != 0) {
            if (node == null) {
                node = new ListNode(((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remain) % 10);
                root = node;
            } else {
                node.next = new ListNode(((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remain) % 10);
                node = node.next;
            }
            remain = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remain)/10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        node = problem2.addTwoNumbers(node,node2);
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
