/**
 * Created by Zhehui Zhou on 3/31/16.
 */
public class Problem172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
