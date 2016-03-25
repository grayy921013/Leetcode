import java.util.HashSet;

/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
