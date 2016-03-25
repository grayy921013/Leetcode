/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem137 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for(int i = 0; i < nums.length; i++) {
            two |= (one & nums[i]);
            one ^= nums[i];
            int three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
    }
}
