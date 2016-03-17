/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);
        int length1 = s1.length();
        int length2 = s2.length();
        boolean[][] match = new boolean[length1 + 1][length2 + 1];
        //match[i][j] is true if s3[0..i + j) is interleaved by s1[0..i) and s2[0..j)
        match[0][0] = true;
        for(int i = 1; i <= length1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) match[i][0] = true;
            else break;
        }
        for(int i = 1; i <= length2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) match[0][i] = true;
            else break;
        }
        for(int i = 1; i <= length1; i++) {
            for(int j = 1; j <= length2; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c = s3.charAt(i + j - 1);
                if (c == c1 && match[i - 1][j]) match[i][j] = true;
                else if (c == c2 && match[i][j - 1]) match[i][j] = true;
            }
        }
        return match[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(new Problem97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
