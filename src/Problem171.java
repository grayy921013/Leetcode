/**
 * Created by Zhehui Zhou on 3/31/16.
 */
public class Problem171 {
    public int titleToNumber(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            num = num * 26 + s.charAt(i) - 'A' + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Problem171().titleToNumber("AB"));
    }
}
