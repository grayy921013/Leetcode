/**
 * Created by Zhehui Zhou on 4/9/16.
 */
public class Problem231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
