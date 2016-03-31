/**
 * Created by Zhehui Zhou on 3/31/16.
 */
public class Problem169 {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        while(length > 1) {
            int newLength = 0;
            for(int i = 0; i < length; i+=2) {
                if(i + 1 >= length || nums[i] == nums[i + 1]) nums[newLength++] = nums[i];
            }
            length = newLength;
        }
        return nums[0];
    }

}
