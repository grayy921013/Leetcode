/**
 * Created by Zhehui Zhou on 3/29/16.
 */
public class Problem152 {
    public int maxProduct(int[] nums) {
        int posProduct = -1;
        int negProduct = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (posProduct <= 0) posProduct = nums[i];
                else posProduct *= nums[i];
                if (negProduct < 0) negProduct *= nums[i];
            } else if (nums[i] < 0) {
                int temp = posProduct;
                if (negProduct < 0) posProduct = negProduct * nums[i];
                else posProduct = -1;
                if (temp <= 0) negProduct = nums[i];
                else if (temp > 0) negProduct = temp * nums[i];
            } else {
                posProduct = 0;
                negProduct = 0;
            }
            if (negProduct <= 0 && negProduct > max) max = negProduct;
            if (posProduct >= 0 && posProduct > max) max = posProduct;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem152().maxProduct(new int[]{3,-1,4}));
    }
}
