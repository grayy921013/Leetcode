/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem75 {
    public void sortColors(int[] nums) {
        //actually 3-way quicksort
        int rIndex = 0, wIndex = 0, bIndex = nums.length - 1;
        while (wIndex <= bIndex) {
            if(nums[wIndex] == 1) wIndex++;
            else if (nums[wIndex] < 1) {
                nums[wIndex++] = nums[rIndex];
                nums[rIndex++] = 0;
            } else {
                nums[wIndex] = nums[bIndex];
                nums[bIndex--] = 2;
            }
        }
    }
}
