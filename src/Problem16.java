import java.util.Arrays;

/**
 * Created by admin on 2/25/16.
 */
public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicate values
            int sum = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (Math.abs(result - target) > Math.abs(nums[start] + nums[end] - sum))
                    result = nums[i] + nums[start] + nums[end];
                if (nums[start] + nums[end] > sum) end--;
                else if (nums[start] + nums[end] < sum) start++;
                else return target;
            }
        }
        return result;
    }
}
