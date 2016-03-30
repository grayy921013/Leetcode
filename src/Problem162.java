/**
 * Created by Zhehui Zhou on 3/30/16.
 */
public class Problem162 {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int fromIndex, int toIndex) {
        if (isPeak(nums, fromIndex)) return fromIndex;
        if (isPeak(nums, toIndex)) return toIndex;
        int mid = (fromIndex + toIndex) >>> 1;
        if (isPeak(nums, mid)) return mid;
        if (nums[mid - 1] > nums[mid]) return findPeakElement(nums, fromIndex, mid - 1);
        if (nums[mid + 1] > nums[mid]) return findPeakElement(nums, mid + 1, toIndex);
        return -1;
    }

    private boolean isPeak(int[] nums, int index) {
        if((index == 0 || nums[index - 1] < nums[index]) &&
                (index == nums.length - 1 || nums[index + 1] < nums[index])) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem162().findPeakElement(new int[]{1,2,3,4,5,4}));
    }
}
