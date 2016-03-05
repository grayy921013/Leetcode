/**
 * Created by admin on 3/5/16.
 */
public class Problem45 {
    public int jump(int[] nums) {
        int stepCount = 0;
        int range = 0;
        int maxReachable = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //update max reachable index if it is smaller than i + nums[i]
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == range) {
                //reach the range, update step count and range
                stepCount++;
                range = maxReachable;
            }
        }
        return stepCount;
    }
}
