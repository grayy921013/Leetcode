/**
 * Created by Zhehui Zhou on 3/9/16.
 */
public class Problem70 {
    public int climbStairs(int n) {
        //actually Fibonacci
        int a = 1, b = 1;
        while (n-- > 1) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
