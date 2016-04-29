/**
 * Created by Zhehui Zhou on 4/29/16.
 */
public class Problem342 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num&0x55555555) != 0;
    }
}
