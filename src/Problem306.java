/**
 * Created by Zhehui Zhou on 4/17/16.
 */
public class Problem306 {
    public boolean isAdditiveNumber(String num) {
        int start = 0, end = num.length();
        if(end - start < 3) return false;
        //start,i,j,end
        int i = start + 1, j = i + 1;
        while (i - start <= end - j) {
            long a = Long.parseLong(num.substring(start, i));
            if (a != 0 && num.startsWith("0")) return false;
            while(j - i <= end - j) {
                long tempa = a;
                int tempj = j;
                long b = Long.parseLong(num.substring(i, j));
                if (b != 0 && num.startsWith("0", i)) {
                    j = tempj + 1;
                    a = tempa;
                    break;
                }
                long c = a + b;
                while (num.substring(j).startsWith(Long.toString(c))) {
                    //a match
                    a = b;
                    b = c;
                    c = a + b;
                    j += Long.toString(b).length();
                    if (j == num.length()) return true;
                }
                j = tempj + 1;
                a = tempa;
            }
            i++;
            j = i + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem306().isAdditiveNumber("123"));
    }
}
