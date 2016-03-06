/**
 * Created by Zhehui Zhou on 3/6/16.
 */
public class Problem50 {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) return myPow(x, n + 1) / x;
        if (n < 0) return 1/myPow(x, -n);
        if (n == 0) return 1;
        double result = 1;
        while (n > 0) {
            result *= (n % 2 == 1 ? x : 1);
            x *= x;
            n /= 2;
        }
        return result;
    }
}
