/**
 * Created by Zhehui Zhou on 3/15/16.
 */
public class Program86 {
    public ListNode partition(ListNode head, int x) {
        ListNode[] part = new ListNode[2];
        ListNode[] partHead = new ListNode[2];
        while (head != null) {
            int i = head.val < x ? 0 : 1;
            if (part[i] == null) {
                part[i] = head;
                partHead[i] = head;
            } else {
                part[i].next = head;
                part[i] = head;
            }
            head = head.next;
        }
        if (part[0] != null) part[0].next = partHead[1];
        if (part[1] != null) part[1].next = null;
        return partHead[0] == null ? partHead[1] : partHead[0];
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        System.out.println(new Program86().partition(node, 2));
    }
}
