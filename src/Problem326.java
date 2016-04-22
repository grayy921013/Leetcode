/**
 * Created by Zhehui Zhou on 4/22/16.
 */
public class Problem326 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}
