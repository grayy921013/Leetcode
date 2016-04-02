/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem189 {
    public void rotate(int[] nums, int k) {
        //reverse 0 to n - k, n - k to n, then 0 to n
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
