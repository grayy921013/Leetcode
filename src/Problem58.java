/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;
        for(i = s.length() - 1; i >=0 && s.charAt(i) == ' '; i--);
        for(; i >=0 && s.charAt(i) != ' '; i--) length++;
        return length;
    }
}
