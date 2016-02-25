import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2/25/16.
 */
public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array, pick an item as the first item, and do 2sum on the array at the right of the first item
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicate values
            int sum = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] > sum) end--;
                else if (nums[start] + nums[end] < sum) start++;
                else {
                    lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start + 1] == nums[start++]) ;
                    while (start < end && nums[end - 1] == nums[end--]) ;
                }
            }
        }
        return lists;
    }
}
