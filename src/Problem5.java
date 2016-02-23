/**
 * Created by admin on 2/23/16.
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        int center = 0;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int length = longestPalindrome(s, i, i);
            if (length > max) {
                center = i;
                max = length;
            }
            length = longestPalindrome(s, i, i + 1);
            if (length > max) {
                center = i;
                max = length;
            }
        }
        return s.substring(center - max / 2 + (max + 1) % 2, center + max / 2 + 1);
    }

    public int longestPalindrome(String s, int start, int end) {
        //palindrome string centered at (start,end)
        if (start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end)) return 0;
        return (start == end ? 1 : 2) + longestPalindrome(s, start - 1, end + 1);
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        System.out.println(problem5.longestPalindrome("aaaavvvbs"));
    }
}
