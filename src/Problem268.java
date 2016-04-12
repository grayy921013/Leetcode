/**
 * Created by Zhehui Zhou on 4/12/16.
 */
public class Problem268 {
    public int missingNumber(int[] nums) {
        int result = 0;
        int i = 1;
        for(int num : nums) {
            result ^= i;
            result ^= num;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem268().missingNumber(new int[]{2,3,0}));
    }
}
