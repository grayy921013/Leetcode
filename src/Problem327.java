import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/25/16.
 */
public class Problem327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= lower && sum <= upper) count++;
        }
        List<Long> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index1 = binarySearchGround(list, lower + sum);
            int index2 = binarySearchCeil(list, upper + sum);
            if (index1 < 0 && index2 < 0) count += index1 - index2;
            else if (index1 >= 0 && index2 < 0) count += -index2 - 1 - index1;
            else if (index2 >= 0 && index1 < 0) count += index2 + index1 + 2;
            else count += index2 - index1 + 1;
            int index = Collections.binarySearch(list, sum);
            if (index < 0) index = -index - 1;
            list.add(index, sum);
            sum -= nums[i];
        }
        return count;
    }

    private int binarySearchGround(List<Long> list, long val) {
        int start = 0, end = list.size() - 1;
        int hit = -1;
        while(start <= end) {
            int mid = (start + end) >>> 1;
            if (list.get(mid) > val) end = mid - 1;
            else if (list.get(mid) < val) start = mid + 1;
            else {
                hit = mid;
                end = mid - 1;
            }
        }
        return hit >= 0 ? hit : -(start + 1);
    }

    private int binarySearchCeil(List<Long> list, long val) {
        int start = 0, end = list.size() - 1;
        int hit = -1;
        while(start <= end) {
            int mid = (start + end) >>> 1;
            if (list.get(mid) > val) end = mid - 1;
            else if (list.get(mid) < val) start = mid + 1;
            else {
                hit = mid;
                start = mid + 1;
            }
        }
        return hit >= 0 ? hit : -(start + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem327().countRangeSum(new int[]{0,0,-3,2,-2,-2},-3,1));
    }
}
