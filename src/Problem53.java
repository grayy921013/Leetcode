/**
 * Created by Zhehui Zhou on 3/7/16.
 */
public class Problem53 {
    public int maxSubArray(int[] nums) {
        int start = 0;
        int max = Integer.MIN_VALUE;
        while(start < nums.length) {
            int sum = 0;
            while(start < nums.length && nums[start] <= 0) {
                if (nums[start] > max) max = nums[start];
                start++;
            }
            while(sum >= 0 && start < nums.length) {
                sum += nums[start];
                if (sum > max) max = sum;
                start++;
            }
        }
        return max;
    }
}
