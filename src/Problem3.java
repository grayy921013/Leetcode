import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by admin on 2/18/16.
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        //HashSet<Character> set = new HashSet<>();
        //use hashmap can move i quickly
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer pos = map.put(s.charAt(i), i);
            if (pos == null || pos < start) {
                // start to i is a string without repeating characters
                if (i + 1 - start > length) length = i + 1 - start;
            } else {
                // should change the value of start
                start = pos + 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("abcabcbb") + "");
        System.out.println(problem3.lengthOfLongestSubstring("bbbbb") + "");
    }
}
