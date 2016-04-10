/**
 * Created by Zhehui Zhou on 4/10/16.
 */
public class Problem237 {
    public void deleteNode(ListNode node) {
        //don't be stupid, you actually can modify the value of a node
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
