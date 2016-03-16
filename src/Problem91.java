/**
 * Created by Zhehui Zhou on 3/16/16.
 */
public class Problem91 {
    public int numDecodings(String s) {
        //same idea as fibonacci
        if (s.length() == 0) return 0;
        int index = s.length() - 2;
        int result1 = s.charAt(index + 1) == '0' ? 0 : 1;
        int result0 = 1;
        while (index >= 0) {
            if (s.charAt(index) == '0') {
                result0 = result1;
                result1 = 0;
            } else if (s.charAt(index) > '0' && s.charAt(index) < '2' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6') {
                result1 = result0 + result1;
                result0 = result1 - result0;
            } else {
                result0 = result1;
            }
            index--;
        }
        return result1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem91().numDecodings("10"));
    }
}
