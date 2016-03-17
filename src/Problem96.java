/**
 * Created by Zhehui Zhou on 3/17/16.
 */
public class Problem96 {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int k = 0; k <= i - 1; k++) {
                nums[i] += nums[k] * nums[i - 1 - k];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        new Problem96().numTrees(1);
    }
}
