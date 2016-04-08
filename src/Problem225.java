import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Zhehui Zhou on 4/8/16.
 */
public class Problem225 {
    Queue<Integer> a = new ArrayDeque<>();
    Queue<Integer> b = new ArrayDeque<>();
    // Push element x onto stack.
    public void push(int x) {
        a.offer(x);
        for(int i = 0; i < a.size() - 1; i++) a.offer(a.poll());
        if (a.size() * a.size() > b.size()) {
            while(!b.isEmpty()) a.offer(b.poll());
            Queue<Integer> temp = a;
            a = b;
            b = temp;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!a.isEmpty()) a.poll();
        else b.poll();
    }

    // Get the top element.
    public int top() {
        if (!a.isEmpty()) return a.peek();
        else return b.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }

    public static void main(String[] args) {
        Problem225 problem225 = new Problem225();
        problem225.push(1);
        problem225.push(2);
        System.out.println(problem225.top());
    }
}
