/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem213 {
    public int rob(int[] nums) {
        int[] array = new int[nums.length + 1];
        int[] array2 = new int[nums.length + 1];
        for(int i = 0; i < nums.length - 1; i++) {
            array[i + 2] = Math.max(array[i + 1], array[i] + nums[i]);
            array2[i + 2] = Math.max(array2[i + 1], array2[i] + nums[i + 1]);
        }
        return Math.max(array[nums.length], array2[nums.length]);
    }

    public static void main(String[] args) {
        new Problem213().rob(new int[]{1, 2, 1, 1});
    }
}
