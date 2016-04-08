import java.util.Stack;

/**
 * Created by Zhehui Zhou on 4/8/16.
 */
public class Problem227 {
    public int calculate(String s) {
        int preVal = 0;
        int result = 0;
        int num = 0;
        char sign = '+';
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
                if (i < s.length() - 1) continue;
            }
            if (sign == '+') {
                result += preVal;
                preVal = num;
            } else if (sign == '-') {
                result += preVal;
                preVal = -num;
            } else if (sign == '*') {
                preVal = preVal * num;
            } else {
                preVal = preVal / num;
            }
            sign = s.charAt(i);
            num = 0;
        }
        result += preVal;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem227().calculate("1+1"));
    }
}
