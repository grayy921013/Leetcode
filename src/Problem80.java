/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int prev = nums[0];
        int count = 0;
        int index = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                if (++count >= 2) continue;
            } else {
                prev = nums[i];
                count = 0;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Problem80().removeDuplicates(new int[]{1, 1, 1}));
    }
}
