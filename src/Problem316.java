import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 4/20/16.
 */
public class Problem316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int charCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 0) charCount++;
            count[s.charAt(i) - 'a']++;
        }
        String result = "";
        char c;
        int lastIndex = -1;
        int start = 0;
        int[] tempCount = null;
        while(result.length() < charCount) {
            c = 'z';
            for(int i = start; i < s.length(); i++) {
                if (s.charAt(i) < c && count[s.charAt(i) - 'a'] > 0) {
                    c = s.charAt(i);
                    lastIndex = i;
                    tempCount = Arrays.copyOf(count, count.length);
                }
                count[s.charAt(i) - 'a']--;
                if (count[s.charAt(i) - 'a'] == 0) {
                    result += c;
                    count = tempCount;
                    count[c - 'a'] = 0;
                    start = lastIndex + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem316().removeDuplicateLetters("baab"));
    }
}
