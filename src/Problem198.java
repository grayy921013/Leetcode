/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem198 {
    public int rob(int[] nums) {
        int[] amount = new int[nums.length + 2];
        for(int i = 2; i < amount.length; i++) {
            amount[i] = Math.max(amount[i - 1], amount[i - 2] + nums[i - 2]);
        }
        return amount[amount.length - 1];
    }
}
