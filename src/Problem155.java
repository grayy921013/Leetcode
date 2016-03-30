import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/30/16.
 */
public class Problem155 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int val = stack.pop();
        if (val == min) min = stack.pop();
        if (stack.isEmpty()) min = Integer.MAX_VALUE;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
