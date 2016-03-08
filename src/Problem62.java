/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem62 {
    public int uniquePaths(int m, int n) {
        long sum = 1;
        m = m - 1;
        n = n - 1;
        for (int i = 0; i < Math.min(m, n); i++) {
            sum = sum * (m + n - i);
            sum = sum / (i + 1);
        }
        return (int)sum;
    }
}
