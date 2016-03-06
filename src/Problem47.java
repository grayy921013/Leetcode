import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/6/16.
 */
public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //similar to problem46, but nums may contain duplicate values
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        permuteUnique(lists, list, 0, nums);
        return lists;
    }

    private void permuteUnique(List<List<Integer>> lists, ArrayList<Integer> list, int index, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(list);
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.add(i, nums[index]);
            permuteUnique(lists, list1, index + 1, nums);
            // To prevent duplication, only insert nums[index] on the left of entries with equal value
            if (i < list.size() && list.get(i) == nums[index]) break;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem47().permuteUnique(new int[]{1, 1, 2}));
    }
}
