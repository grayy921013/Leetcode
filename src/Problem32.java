import java.util.Stack;

/**
 * Created by admin on 3/2/16.
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        //use stack to store the index of left parentheses
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == '(') stack.push(j);
            else {
                if (stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, j - left);
                    else max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem32().longestValidParentheses(")()"));
    }
}
