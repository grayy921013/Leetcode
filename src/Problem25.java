

/**
 * Created by admin on 2/29/16.
 */
public class Problem25 {
    //similar to problem23, but in k groups
    //if remaining nodes is less than k, than they should not change the order
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        int count = 0;
        while (count < k && tail != null) {
            count ++;
            tail = tail.next;
        }
        if (count == k && k > 1) {
            //enough node, reverse n nodes
            ListNode headNow = head;
            for(int i = 0; i < k - 1; i++) {
                //headnow .... head -> tail to tail->headnow .... head
                tail = head.next;
                head.next = tail.next;
                tail.next = headNow;
                headNow = tail;
            }
            head.next = reverseKGroup(head.next, k);
            return tail;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        new Problem25().reverseKGroup(node, 2);
    }
}
