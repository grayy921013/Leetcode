/**
 * Created by admin on 3/5/16.
 */
public class Problem44 {
    //    '?' Matches any single character.
//    '*' Matches any sequence of characters (including the empty sequence).
    public boolean isMatch(String s, String p) {
        //use dp instead of dfs
        int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        //entry i,j denotes whether p[0..j-1] can match s[0..i-1]
        match[0][0] = true;
        //entry 0,j is true if all characters in p before index j is '*'
        //all entry i,0 for i > 1 is false
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') match[0][j] = true;
            else break;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (p.charAt(j - 1) != '*') {
                    match[i][j] = (match[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'));
                } else {
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                }
            }
        }
        return match[m][n];
    }

    public static void main(String[] args) {
        Problem44 problem44 = new Problem44();
        System.out.println(problem44.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }
}
