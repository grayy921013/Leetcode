import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 4/11/16.
 */
public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int num = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = num;
            num *= nums[i];
        }
        num = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= num;
            num *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new Problem238().productExceptSelf(nums)));
    }
}
