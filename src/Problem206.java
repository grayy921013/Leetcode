/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode next = head.next;
        head.next = null;
        while(next != null) {
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        new Problem206().reverseList(node);
    }
}
