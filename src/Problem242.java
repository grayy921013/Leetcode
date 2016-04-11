import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 4/11/16.
 */
public class Problem242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        for(int i = 0; i < s.length(); i++) {
            if(sArray[i] != tArray[i]) return false;
        }
        return true;
    }
}
