/**
 * Created by admin on 2/24/16.
 */
public class Problem8 {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        boolean sign = true;
        int result = 0;
        int i = 0;
        for(;Character.isWhitespace(str.charAt(i));i++);
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i) == '+';
            i++;
        }
        for(;i<str.length();i++) {
            if(!Character.isDigit(str.charAt(i))) break;
            //handle overflow
            if (result * 10 / 10 != result) return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + str.charAt(i) - 48;
            //handle overflow
            if (result < 0) return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign ? result : -result;
    }

    public static void main(String[] args) {
        Problem8 problem8 = new Problem8();
        System.out.println(problem8.myAtoi("2147483648")+"");
        System.out.println(problem8.myAtoi("     -89811111")+"");
    }
}
