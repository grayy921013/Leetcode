import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by admin on 2/29/16.
 */
public class Problem23 {
    //Merge k sorted linked lists and return it as one sorted list.

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        ListNode head = queue.poll();
        if (head != null && head.next != null) queue.add(head.next);
        ListNode prev = head;
        while(!queue.isEmpty()) {
            prev.next = queue.poll();
            prev = prev.next;
            if (prev.next != null) queue.add(prev.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next = new ListNode(2);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next = new ListNode(2);
        new Problem23().mergeKLists(new ListNode[]{node,node2});
    }
}
