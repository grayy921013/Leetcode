/**
 * Created by admin on 3/1/16.
 */
public class Problem27 {
    //Given an array and a value, remove all instances of that value in place and return the new length.

    //The order of elements can be changed. It doesn't matter what you leave beyond the new length.

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[count++] = nums[i];
        }
        return count;
    }
}
