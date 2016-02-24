/**
 * Created by admin on 2/24/16.
 */
public class Problem10 {
    //Implement regular expression matching with support for '.' and '*'.
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        char c1 = p.charAt(0);
        if (p.length() == 1) return s.length() == 1 && (s.charAt(0) == c1 || c1 == '.');
        if (p.charAt(1) == '*') {
            //support for '*'
            for (int i = 0; i == 0 || i <= s.length() && (c1 == '.' || s.charAt(i-1) == c1); i++)
                if (isMatch(s.substring(i), p.substring(2)))
                    return true;
            return false;
        } else {
            //only process one character
            if (s.length() == 0) return false;
            if (c1 == '.' || s.charAt(0) == c1) return isMatch(s.substring(1), p.substring(1));
            else return false;
        }
    }

    public static void main(String[] args) {
        Problem10 problem10 = new Problem10();
        System.out.println(problem10.isMatch("a", ".*..a*"));
        System.out.println(problem10.isMatch("a", "ab*"));
        System.out.println(problem10.isMatch("ab", ".*c"));
        System.out.println(problem10.isMatch("", ".*"));
        System.out.println(problem10.isMatch("aa", ".*"));
        System.out.println(problem10.isMatch("ab", ".*"));
        System.out.println(problem10.isMatch("aab", "c*a*b"));
    }
}
