/**
 * Created by Zhehui Zhou on 3/28/16.
 */
public class Problem148 {
    public ListNode sortList(ListNode head) {
        return quickSortList(head)[0];
    }

    private ListNode[] quickSortList(ListNode head) {
        if (head == null) return new ListNode[]{head, head};
        ListNode pivot = head;
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode equalHead = head;
        ListNode equalTail = head;
        ListNode bigHead = null;
        ListNode bigTail = null;
        head = head.next;
        while(head != null) {
            if (head.val < pivot.val) {
                if (smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
            } else if (head.val == pivot.val) {
                equalTail.next = head;
                equalTail = head;
            } else {
                if (bigHead == null) {
                    bigHead = head;
                    bigTail = head;
                } else {
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            head = head.next;
        }
        if (smallTail != null) smallTail.next = null;
        equalTail.next = null;
        if (bigTail != null) bigTail.next = null;
        ListNode[] smallNodes = quickSortList(smallHead);
        ListNode[] bigNodes = quickSortList(bigHead);
        if (smallNodes[1] != null) smallNodes[1].next = equalHead;
        equalTail.next = bigNodes[0];
        return new ListNode[]{smallNodes[0] == null ? equalHead : smallNodes[0], bigNodes[1] == null ? equalTail : bigNodes[1]};
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(2);
        list.next.next = new ListNode(1);
        System.out.println(new Problem148().sortList(list));
    }
}
