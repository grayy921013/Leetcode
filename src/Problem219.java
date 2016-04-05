import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if(index != null && i - index <= k) return true;
            map.put(nums[i], i);
            if(i - k >= 0) map.remove(nums[i - k]);
        }
        return false;
    }
}
