import java.util.HashSet;

/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem217 {
    HashSet<Integer> set = new HashSet<>();
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
