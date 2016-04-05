/**
 * Created by Zhehui Zhou on 4/4/16.
 */
public class Problem209 {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = nums.length + 1;
        while(end < nums.length) {
            while(end < nums.length && sum < s) {
                sum += nums[end++];
            }
            if (sum < s) break;
            while(start < end && sum >= s) {
                sum -= nums[start++];
            }
            min = Math.min(min, end - start + 1);
        }
        return min;
    }
}
