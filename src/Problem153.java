/**
 * Created by Zhehui Zhou on 3/30/16.
 */
public class Problem153 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int mid = (start + end) / 2;
        int min = nums[0];
        if (nums[start] < nums[mid]) {
            min = Math.min(min, nums[start]);
        } else {
            min = Math.min(min, findMin(nums, start, mid - 1));
        }
        if (nums[mid] < nums[end]) {
            min = Math.min(min, nums[start]);
        } else {
            min = Math.min(min, findMin(nums, mid + 1, end));
        }
        return min;
    }
}
