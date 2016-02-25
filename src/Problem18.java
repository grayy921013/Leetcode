import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2/25/16.
 */
public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicate values
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //skip duplicate values
                int sum = target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] > sum) end--;
                    else if (nums[start] + nums[end] < sum) start++;
                    else {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start + 1] == nums[start++]) ;
                        while (start < end && nums[end - 1] == nums[end--]) ;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Problem18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
