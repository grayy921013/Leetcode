import java.util.HashMap;

/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cursor = head;
        //associate the original node with its copy node in a single linked list
        while (cursor != null) {
            RandomListNode next = cursor.next;
            RandomListNode copy = new RandomListNode(cursor.label);
            cursor.next = copy;
            copy.next = next;
            cursor = next;
        }
        //link the random pointer
        cursor = head;
        while (cursor != null) {
            if (cursor.random != null) cursor.next.random = cursor.random.next;
            cursor = cursor.next.next;
        }
        //recover the copy and the original list
        RandomListNode copyHead = head.next;
        RandomListNode copyCursor = copyHead;
        cursor = head;
        while (cursor != null) {
            copyCursor = cursor.next;
            cursor.next = cursor.next.next;
            copyCursor.next = cursor.next == null ? null : cursor.next.next;
            cursor = cursor.next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        new Problem138().copyRandomList(new RandomListNode(-1));
    }
}
