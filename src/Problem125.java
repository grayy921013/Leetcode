/**
 * Created by Zhehui Zhou on 3/22/16.
 */
public class Problem125 {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if (start > end) break;
            char ch1 = Character.toLowerCase(s.charAt(start++));
            char ch2 = Character.toLowerCase(s.charAt(end--));
            if (ch1 != ch2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Problem125().isPalindrome("aA");
    }
}
