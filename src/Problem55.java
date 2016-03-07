/**
 * Created by Zhehui Zhou on 3/7/16.
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        //This problem is very similar to Problem45
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }
}
