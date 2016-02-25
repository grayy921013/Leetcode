import java.util.Stack;

/**
 * Created by admin on 2/25/16.
 */
public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char c2 = stack.pop();
                if (!((c == ')' && c2 == '(') || (c == ']' && c2 == '[') || (c == '}' && c2 == '{'))) return false;
            }
        }
        return stack.isEmpty();
    }
}
