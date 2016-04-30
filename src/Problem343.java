/**
 * Created by Zhehui Zhou on 4/30/16.
 */
public class Problem343 {
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        int a = 1;
        if(n % 3 == 1) {
            a = 4;
            n -= 4;
        } else if (n % 3 == 2) {
            a = 2;
            n -= 2;
        }
        while (n > 0) {
            a = a * 3;
            n -= 3;
        }
        return a;
    }
}
