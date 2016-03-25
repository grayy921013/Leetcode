import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;
        for(int i = 0; i < s.length(); i++) {
            for(String word : wordDict) {
                if(i + 1 - word.length() >= 0 && match[i + 1 - word.length()] && match(s, i, word)) {
                    match[i + 1] = true;
                    break;
                }
            }
        }
        return match[s.length()];
    }

    private boolean match(String s, int align, String word) {
        int index = word.length() - 1;
        while(index >= 0) {
            if(s.charAt(align--) != word.charAt(index--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(new Problem139().wordBreak("leetcode", dict));
    }
}
