/**
 * Created by admin on 3/1/16.
 */
public class Problem26 {
    //Given a sorted array, remove the
    // duplicates in place such that each element appear only once and return the new length
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev = nums[0];
        int count = 1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) continue;
            prev = nums[i];
            nums[count] = prev;
            count++;
        }
        return count;
    }
}
