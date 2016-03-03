import java.util.Arrays;

/**
 * Created by admin on 3/3/16.
 */
public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < nums[mid]) end = mid - 1;
            else if (target > nums[mid]) start = mid + 1;
            else {
                //search for target in both direction
                start = searchForBegin(nums, start, mid, target);
                end = searchForStop(nums, mid, end, target);
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }

    private int searchForBegin(int[] nums, int start, int end, int target) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= nums[mid]) {
                end = mid - 1;
                if (target == nums[mid]) result = mid;
            }
            else start = mid + 1;
        }
        return result;
    }

    private int searchForStop(int[] nums, int start, int end, int target) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < nums[mid]) end = mid - 1;
            else {
                start = mid + 1;
                if (target == nums[mid]) result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem34().searchRange(new int[]{2,2}, 2)));
    }
}
