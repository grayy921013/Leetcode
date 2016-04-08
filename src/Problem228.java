import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/8/16.
 */
public class Problem228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++) {
            if (i < nums.length && nums[i] == end + 1) end += 1;
            else {
                if (start == end) result.add(Integer.toString(start));
                else result.add(start + "->" + end);
                if (i < nums.length) {
                    start = nums[i];
                    end = nums[i];
                }
            }
        }
        return result;
    }
}
