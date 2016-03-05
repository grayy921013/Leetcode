/**
 * Created by admin on 3/5/16.
 */
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        //basic idea is to put all positive numbers i to nums[i-1]
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            while (number <= nums.length && number > 0 && nums[number - 1] != number) {
                nums[i] = nums[number - 1];
                nums[number - 1] = number;
                number = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem41().firstMissingPositive(new int[]{1, 1}));
    }
}
