/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem214 {
    public String shortestPalindrome(String s) {
        for(int i = s.length() / 2; i >= 0; i--) { //the center can only be in the first two half\
            if (isPalindrome(s, i, i)) {
                String notMatched = s.substring(2 * i + 1);
                StringBuilder builder = new StringBuilder(notMatched).reverse();
                return builder.append(s).toString();
            }
            if(isPalindrome(s, i - 1, i)) {
                String notMatched = s.substring(2 * i);
                StringBuilder builder = new StringBuilder(notMatched).reverse();
                return builder.append(s).toString();
            }
        }
        return s;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0 || s.length() - end < start + 1) return false;
        while (start >= 0) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start--;
            end++;
        }
        return true;
    }
}
