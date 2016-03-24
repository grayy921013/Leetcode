import java.util.HashMap;

/**
 * Created by Zhehui Zhou on 3/23/16.
 */
public class Problem128 {
    public int longestConsecutive(int[] nums) {
        //keep track of the sequence length on both end
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int sum = left + right + 1;
            max = Math.max(max, sum);
            map.put(num, sum);
            if (left != 0) map.put(num - left, sum);
            if (right != 0) map.put(num + right, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem128().longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
    }
}
