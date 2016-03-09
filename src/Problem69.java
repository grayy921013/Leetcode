/**
 * Created by Zhehui Zhou on 3/9/16.
 */
public class Problem69 {
    public int mySqrt(int x) {
        //use Newton's method x(k+1) = x(k) - f(x)/f'(x)
        long n = x;
        while (n * n > x) {
            //n = n - (n*n - x) /(2*n)
            n = (n + x/n) / 2;
        }
        return (int)n;
    }
}
