import java.util.TreeSet;

/**
 * Created by Zhehui Zhou on 4/6/16.
 */
public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            Integer num = set.ceiling(nums[i] - t);
            if (num != null && num <= (long)nums[i] + t) return true;
            set.add(nums[i]);
            if(i >= k) set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem220().containsNearbyAlmostDuplicate(new int[]{0,2147483647}, 1, 2147483647));
    }
}
