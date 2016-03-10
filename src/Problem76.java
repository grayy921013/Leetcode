import java.util.HashMap;

/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem76 {
    public String minWindow(String s, String t) {
        //As we check for character, we can use a
        int[] map = new int[256];
        int[] ref = new int[256];
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ref[c]++;
        }
        int count = 0;
        int start = 0,end = 0;
        int need = t.length();
        int length = s.length() + 1, minS = 0, minE = 0;
        while (end < s.length()) {
            char c = s.charAt(end++);
            if (ref[c] != 0) {
                if (map[c]++ < ref[c]) count++;
            }
            if (count != need) continue;
            while (true) {
                c = s.charAt(start++);
                if (ref[c] != 0) {
                    if (ref[c] >= map[c]--) {
                        count--;
                        break;
                    }
                }
            }
            //[start - 1, end - 1] is a solution
            if (end - start + 1 < length) {
                length = end - start + 1;
                minS = start  - 1;
                minE = end;
            }
        }
        return s.substring(minS, minE);
    }

    public static void main(String[] args) {
        System.out.println(new Problem76().minWindow("aafefefwegfwegc", "ac"));
    }
}
