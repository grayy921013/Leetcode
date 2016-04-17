/**
 * Created by Zhehui Zhou on 4/17/16.
 */
public class Problem303 {
    int[] nums;

    public Problem303(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
    }

    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];
        return nums[j] - nums[i - 1];
    }

    public static void main(String[] args) {
        Problem303 problem303 = new Problem303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(problem303.sumRange(2, 5));
    }
}
