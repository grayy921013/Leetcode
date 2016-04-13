import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/13/16.
 */
public class Problem282 {
    public List<String> addOperators(String num, int target) {
        List<String> list = getResult(num, num.length() - 1);
        List<String> result = new ArrayList<>();
        for(String s : list) {
            if(calculate(s) == target) result.add(s);
        }
        return result;
    }

    private List<String> getResult(String num, int end) {
        if (end < 0) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        List<String> result = new ArrayList<>();
        List<String> list = getResult(num, end - 1);
        for (String s : list) {
            if(s.length() < 1 || s.charAt(s.length() - 1) != '0' || (s.length() > 1 && Character.isDigit(s.charAt(s.length() - 2))))
                result.add(s + num.charAt(end));
            if(s.length() > 0) {
                result.add(s + "+" + num.charAt(end));
                result.add(s + "-" + num.charAt(end));
                result.add(s + "*" + num.charAt(end));
            }
        }
        return result;
    }

    public long calculate(String s) {
        long preVal = 0;
        long result = 0;
        long num = 0;
        char sign = '+';
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
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
            }
            sign = s.charAt(i);
            num = 0;
        }
        result += preVal;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem282().addOperators("2147483648", -2147483648));
    }
}
