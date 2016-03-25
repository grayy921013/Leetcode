import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem140 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] lists = new List[s.length() + 1];
        lists[0] = new ArrayList<>();
        lists[0].add("");
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
        if (!match[s.length()]) return new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            for(String word : wordDict) {
                if(i + 1 - word.length() >= 0 && lists[i + 1 - word.length()] != null && match(s, i, word)) {
                    if (lists[i + 1] == null) lists[i + 1] = new ArrayList<>();
                    for(String str : lists[i + 1 - word.length()]) {
                        lists[i + 1].add(str.equals("") ? word : str + " " + word);
                    }
                }
            }
        }
        return lists[s.length()];
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
        System.out.println(new Problem140().wordBreak("leetcode", dict));
    }
}
