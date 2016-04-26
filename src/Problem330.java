/**
 * Created by Zhehui Zhou on 4/26/16.
 */
public class Problem330 {
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        int i = 1;
        int index = 0;
        while(i <= n) {
            if (i < 0) return patch;
            if (index >= nums.length || nums[index] > i) {
                patch++;
                if (i == 1) i++;
                else {
                    i *= 2;
                }
            } else {
                i += nums[index];
                index++;
            }
        }
        return patch;
    }

    public static void main(String[] args) {
        System.out.println(new Problem330().minPatches(new int[]{}, 8));
    }
}
