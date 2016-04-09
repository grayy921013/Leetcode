import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/9/16.
 */
public class Problem229 {
    public List<Integer> majorityElement(int[] nums) {
        //similar to problem 169
        int num1 = 0, num2 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                cnt1++;
            } else if (nums[i] == num2) {
                cnt2++;
            } else if (cnt1 == 0) {
                num1 = nums[i];
                cnt1++;
            } else if (cnt2 == 0) {
                num2 = nums[i];
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> result = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) cnt1++;
            else if (nums[i] == num2) cnt2++;
        }
        if (cnt1 > nums.length / 3) result.add(num1);
        if (cnt2 > nums.length / 3) result.add(num2);
        return result;
    }

    public static void main(String[] args) {
        new Problem229().majorityElement(new int[]{2,2,1,3});
    }
}
