import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        addCombination(result,new ArrayList<>(), nums, 0);
        return result;
    }

    private void addCombination(List<List<Integer>> result, List<Integer> list, int[] nums, int startIndex) {
        result.add(new ArrayList<>(list));
        if (startIndex == nums.length) return;
        for(int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            addCombination(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
