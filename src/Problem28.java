/**
 * Created by admin on 3/1/16.
 */
public class Problem28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for( int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}
