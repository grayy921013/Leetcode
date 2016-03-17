import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        int minLen = length - 9;
        if (minLen < 0) minLen = 0;
        for(int i = minLen; i <= length - 3 * minLen; i++) {
            int num1 = getNum(s.substring(0, i));
            if (num1 == -1) continue;
            for(int j = i + minLen; j <= length - 2 * minLen; j++) {
                int num2 = getNum(s.substring(i, j));
                if (num2 == -1) continue;
                for(int k = j + minLen; k <= length - minLen; k++) {
                    int num3 = getNum(s.substring(j, k));
                    int num4 = getNum(s.substring(k, length));
                    if (num3 == -1 || num4 == -1) continue;
                    result.add(num1 + "." + num2 + "." + num3 + "." + num4) ;
                }
            }
        }
        return result;
    }


    private int getNum(String s) {
        if (s.length() == 0 || s.length() > 3) return -1;
        if (s.length() > 1 && s.charAt(0) == '0') return -1;
        int num = Integer.parseInt(s);
        if (num > 255) return -1;
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Problem93().restoreIpAddresses("25525511135"));
    }
}
