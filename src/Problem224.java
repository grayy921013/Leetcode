import java.util.Stack;

/**
 * Created by Zhehui Zhou on 4/8/16.
 */
public class Problem224 {
    public int calculate(String s) {
        boolean lastSign = true; //true for pos, false for neg
        Stack<Boolean> signs = new Stack<>();
        signs.push(true);
        int result = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
                continue;
            }
            if (lastSign) result += num;
            else result -= num;
            num = 0;
            if (s.charAt(i) == '-') {
                lastSign = !signs.peek();
            } else if (s.charAt(i) == '+') {
                lastSign = signs.peek();
            } else if (s.charAt(i) == '(') {
                signs.push(lastSign);
            } else if (s.charAt(i) == ')') {
                signs.pop();
            }
        }
        if (lastSign) result += num;
        else result -= num;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem224().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
