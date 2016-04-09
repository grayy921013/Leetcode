/**
 * Created by Zhehui Zhou on 3/31/16.
 */
public class Problem169 {
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (nums[i] == major) count++;
            else count--;
        }
        return major;
    }

}
