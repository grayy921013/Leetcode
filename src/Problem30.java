import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 3/1/16.
 */
public class Problem30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0 || words[0].length() > s.length()) return result;
        HashMap<String, Integer> count = new HashMap<>();
        for (String str : words) {
            Integer i = count.get(str);
            if (i == null) count.put(str, 1);
            else count.put(str, i + 1);
        }
        //count now contains all string in the words list
        int wordLen = words.length * words[0].length();
        for (int i = 0; i < s.length() - wordLen + 1; i++) {
            // i is the start index
            if (match(s.substring(i, i + wordLen), count, words[0].length())) result.add(i);
        }
        return result;
    }

    private boolean match(String s, Map<String, Integer> count, int wordLen) {
        HashMap<String, Integer> helper = new HashMap<>();
        for (int i = 0; i < s.length(); i += wordLen) {
            String sub = s.substring(i, i + wordLen);
            if (count.get(sub) == null) return false;
            //first, update the helper map
            Integer j = helper.get(sub);
            if (j == null) helper.put(sub, 1);
            else helper.put(sub, j + 1);
            //compare helper map with the real map
            if (helper.get(sub) > count.get(sub)) return false;
        }
        return helper.equals(count);
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word", "good", "best", "good"};
        System.out.println(new Problem30().findSubstring(s, words));
    }
}
