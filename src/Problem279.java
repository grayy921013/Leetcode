/**
 * Created by Zhehui Zhou on 4/13/16.
 */
public class Problem279 {
    public int numSquares(int n) {
        int[] num = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            num[i] = i;
            for(int j = 1; j * j <= i; j++) {
                num[i] = Math.min(num[i], 1 + num[i - j * j]);
            }
        }
        return num[n];
    }
}
