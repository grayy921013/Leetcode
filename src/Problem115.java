/**
 * Created by Zhehui Zhou on 3/21/16.
 */
public class Problem115 {
    public int numDistinct(String s, String t) {
        //use DP
        int[] match = new int[s.length() + 1];
        //match[i][j] denotes number of distinct of distinct subsequences of t[0..i] in s[0..j]
        //change to O(n) space
        for(int i = 0; i <= s.length(); i++) match[i] = 1; //all s has one subsequences for empty string
        for(int i = 0; i < t.length(); i++) {
            int prev = match[0];
            match[0] = 0;
            for(int j = 0; j < s.length(); j++) {
                int temp = match[j + 1];
                if(t.charAt(i) == s.charAt(j)) {
                    match[j + 1] = prev + match[j];
                } else {
                    match[j + 1] = match[j];
                }
                prev = temp;
            }
        }
        return match[s.length()];
    }
}
