import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 3/16/16.
 */
public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n, p1 = m - 1, p2 = n - 1;
        while (--p >= 0) {
            if (p1 < 0 || (p2 >= 0 && nums1[p1] < nums2[p2])) nums1[p] = nums2[p2--];
            else nums1[p] = nums1[p1--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[1];
        int[] nums2 = new int[1];
        nums2[0] = 1;
        new Problem88().merge(nums1, 0, nums2, 1);
    }
}
