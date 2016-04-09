import java.util.Stack;

/**
 * Created by Zhehui Zhou on 4/9/16.
 */
public class Problem232 {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        a.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (b.isEmpty()) {
            while(!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        b.pop();
    }

    // Get the front element.
    public int peek() {
        if (b.isEmpty()) {
            while(!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
