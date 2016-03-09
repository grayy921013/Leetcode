/**
 * Created by Zhehui Zhou on 3/9/16.
 */
public class Problem65 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        boolean dot = false;
        boolean e = false;
        boolean number = false;
        boolean needNum = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (c >= '0' && c<= '9') {
                number = true;
                needNum = false;
            } else {
                if (needNum) return false;
                if (c == '.') {
                    if (dot || e) return false;
                    else {
                        dot = true;
                        if (!number) needNum = true;
                    }
                } else if (c == 'e') {
                    if (e || !number) return false;
                    else {
                        e = true;
                        dot = false;
                        number = false;
                        needNum = true;
                    }
                } else return false;
            }
        }
        return !needNum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem65().isNumber(" 005047e+6"));
    }
}
