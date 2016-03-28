import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Zhehui Zhou on 3/28/16.
 */
public class Problem146 {
    private static class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int size = 0;
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head = null;
    ListNode tail = null;
    public Problem146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) return -1;
        //put node to the head of the list
        promoteToHead(node);
        return node.value;
    }
    private void promoteToHead(ListNode node) {
        if (node != head) {
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            if (next != null) next.prev = prev;
            else tail = prev; //the tail is promoted
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    private void deleteTail() {
        ListNode prev = tail.prev;
        map.remove(tail.key);
        if (prev != null) {
            prev.next = null;
            tail.prev = null;
            tail = prev;
        }
        size--;
    }
    public void set(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            node = new ListNode(key, value); //create new node
            map.put(key, node);
            size++;
            if (head != null) head.prev = node;
            node.next = head;
            head = node;
            if (tail == null) tail = node;
        } else {
            node.value = value;
        }
        promoteToHead(node);
        if (size > capacity) deleteTail();
    }

    public static void main(String[] args) {
        Problem146 problem146 = new Problem146(2);
        problem146.set(2,1);
        problem146.set(1,1);
        problem146.get(2);
        problem146.set(4,1);
        System.out.println(problem146.get(1));
    }
}
