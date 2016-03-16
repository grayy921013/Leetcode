import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/16/16.
 */
public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(result, list, nums, 0);
        return result;
    }

    private void subsetsWithDup(List<List<Integer>> result, List<Integer> list, int[] nums, int startIndex) {
        result.add(new ArrayList<Integer>(list));
        int i = startIndex;
        while(i < nums.length) {
            list.add(nums[i]);
            subsetsWithDup(result, list, nums, i + 1);
            list.remove(list.size() - 1);
            while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem90().subsetsWithDup(new int[]{0}));
    }
}
