import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by admin on 2/18/16.
 */
public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                if (nums[i] * 2 == target) {
                    //answer found
                    int[] r = new int[2];
                    r[0] = map.get(nums[i]);
                    r[1] = i;
                    return r;
                }
                //else, let it go, coz assume ONLY one solution
            }
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while(true) {
            if(nums[i]+nums[j]>target) j--;
            else if (nums[i]+nums[j]<target) i++;
            else break;
        }
        int[] r = new int[2];
        r[0] = map.get(nums[i]);
        r[1] = map.get(nums[j]);
        return r;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(Arrays.toString(problem1.twoSum(new int[]{1,2,3},4)));
    }
}
